package com.auticuro.server.config;

import com.auticuro.server.grpc.AccountServiceImpl;
import com.auticuro.server.grpc.TransferServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcServerConfig {

    @Value("${grpc.server.port:6565}")
    private int grpcPort;

    @Bean
    public AccountServiceImpl grpcAccountService() {
        return new AccountServiceImpl();
    }

    @Bean
    public TransferServiceImpl grpcTransferService() {
        return new TransferServiceImpl();
    }

    @Bean
    public Server grpcServer(@Qualifier("grpcAccountService") AccountServiceImpl accountService,
                             @Qualifier("grpcTransferService") TransferServiceImpl transferService) {
        return ServerBuilder.forPort(grpcPort)
                .addService(accountService)
                .addService(transferService)
                .build();
    }
}
