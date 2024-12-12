package com.auticuro.server.config;

import com.auticuro.core.statemachine.WalletStateMachine;
import org.apache.ratis.conf.RaftProperties;
import org.apache.ratis.grpc.GrpcConfigKeys;
import org.apache.ratis.protocol.RaftGroup;
import org.apache.ratis.protocol.RaftGroupId;
import org.apache.ratis.protocol.RaftPeer;
import org.apache.ratis.protocol.RaftPeerId;
import org.apache.ratis.server.RaftServer;
import org.apache.ratis.server.RaftServerConfigKeys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.Collections;
import java.util.UUID;

@Configuration
public class RaftServerConfig {

    @Bean
    public RaftServer raftServer(WalletStateMachine stateMachine) throws Exception {
        String raftServerId = System.getProperty("raft.server.id", "server1");
        int port = Integer.parseInt(System.getProperty("raft.server.port", "8000"));
        
        // Create RaftPeer
        RaftPeer peer = RaftPeer.newBuilder()
                .setId(RaftPeerId.valueOf(raftServerId))
                .setAddress("localhost:" + port)
                .build();

        // Configure Raft properties
        RaftProperties properties = new RaftProperties();
        RaftServerConfigKeys.setStorageDir(properties, 
            Collections.singletonList(new File("/tmp/raft-wallet/" + raftServerId)));
        GrpcConfigKeys.Server.setPort(properties, port);

        // Create Raft group
        RaftGroup raftGroup = RaftGroup.valueOf(
            RaftGroupId.valueOf(UUID.fromString("02511d47-d67c-49a3-9011-abb3109a44c1")),
            Collections.singleton(peer));

        // Create and start RaftServer
        RaftServer.Builder builder = RaftServer.newBuilder()
                .setGroup(raftGroup)
                .setProperties(properties)
                .setServerId(peer.getId())
                .setStateMachine(stateMachine);
                
        RaftServer server = builder.build();
        server.start();
        
        return server;
    }
}
