package com.auticuro.server.grpc;

import com.auticuro.core.entity.Account;
import com.auticuro.core.service.AccountService;
import com.auticuro.proto.*;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl extends AccountServiceGrpc.AccountServiceImplBase {
    
    @Autowired
    private AccountService accountService;

    @Override
    public void createAccount(CreateAccountRequest request, StreamObserver<CreateAccountResponse> responseObserver) {
        try {
            Account account = new Account();
            account.setAccountNumber(request.getAccountNumber());
            account.setAssetType(request.getAssetType());
            account.setUpperLimit(new BigDecimal(request.getUpperLimit()));
            account.setLowerLimit(new BigDecimal(request.getLowerLimit()));
            
            Account created = accountService.createAccount(account);
            
            responseObserver.onNext(CreateAccountResponse.newBuilder()
                .setSuccess(true)
                .setAccount(toProtoAccount(created))
                .build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onNext(CreateAccountResponse.newBuilder()
                .setSuccess(false)
                .setError(e.getMessage())
                .build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getAccount(GetAccountRequest request, StreamObserver<GetAccountResponse> responseObserver) {
        try {
            Account account = accountService.getAccount(request.getAccountNumber());
            
            responseObserver.onNext(GetAccountResponse.newBuilder()
                .setSuccess(true)
                .setAccount(toProtoAccount(account))
                .build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onNext(GetAccountResponse.newBuilder()
                .setSuccess(false)
                .setError(e.getMessage())
                .build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void lockAccount(LockAccountRequest request, StreamObserver<LockAccountResponse> responseObserver) {
        try {
            accountService.lockAccount(request.getAccountNumber());
            
            responseObserver.onNext(LockAccountResponse.newBuilder()
                .setSuccess(true)
                .build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onNext(LockAccountResponse.newBuilder()
                .setSuccess(false)
                .setError(e.getMessage())
                .build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void unlockAccount(UnlockAccountRequest request, StreamObserver<UnlockAccountResponse> responseObserver) {
        try {
            accountService.unlockAccount(request.getAccountNumber());
            
            responseObserver.onNext(UnlockAccountResponse.newBuilder()
                .setSuccess(true)
                .build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onNext(UnlockAccountResponse.newBuilder()
                .setSuccess(false)
                .setError(e.getMessage())
                .build());
            responseObserver.onCompleted();
        }
    }

    private com.auticuro.proto.Account toProtoAccount(Account account) {
        return com.auticuro.proto.Account.newBuilder()
            .setAccountNumber(account.getAccountNumber())
            .setAssetType(account.getAssetType())
            .setBalance(account.getBalance().toString())
            .setUpperLimit(account.getUpperLimit().toString())
            .setLowerLimit(account.getLowerLimit().toString())
            .setLocked(account.getLocked())
            .setVersion(account.getVersion())
            .setCreateTime(account.getCreateTime().toString())
            .setUpdateTime(account.getUpdateTime().toString())
            .build();
    }
}
