package com.auticuro.server.grpc;

import com.auticuro.core.service.TransferRestService;
import com.auticuro.proto.*;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransferServiceImpl extends TransferServiceGrpc.TransferServiceImplBase {
    
    @Autowired
    private TransferRestService transferRestService;

    @Override
    public void transfer(TransferRequest request, StreamObserver<TransferResponse> responseObserver) {
        try {
            transferRestService.transfer(
                request.getTransactionId(),
                request.getFromAccount(),
                request.getToAccount(),
                new BigDecimal(request.getAmount()),
                request.getAssetType(),
                request.getMetadataMap()
            );
            
            responseObserver.onNext(TransferResponse.newBuilder()
                .setSuccess(true)
                .setTransactionId(request.getTransactionId())
                .build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onNext(TransferResponse.newBuilder()
                .setSuccess(false)
                .setError(e.getMessage())
                .setTransactionId(request.getTransactionId())
                .build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void batchTransfer(BatchTransferRequest request, StreamObserver<BatchTransferResponse> responseObserver) {
        List<TransferResponse> results = new ArrayList<>();
        boolean overallSuccess = true;
        
        for (TransferRequest transfer : request.getTransfersList()) {
            try {
                transferRestService.transfer(
                    transfer.getTransactionId(),
                    transfer.getFromAccount(),
                    transfer.getToAccount(),
                    new BigDecimal(transfer.getAmount()),
                    transfer.getAssetType(),
                    transfer.getMetadataMap()
                );
                
                results.add(TransferResponse.newBuilder()
                    .setSuccess(true)
                    .setTransactionId(transfer.getTransactionId())
                    .build());
            } catch (Exception e) {
                overallSuccess = false;
                results.add(TransferResponse.newBuilder()
                    .setSuccess(false)
                    .setError(e.getMessage())
                    .setTransactionId(transfer.getTransactionId())
                    .build());
            }
        }
        
        responseObserver.onNext(BatchTransferResponse.newBuilder()
            .setSuccess(overallSuccess)
            .setBatchId(request.getBatchId())
            .addAllTransferResults(results)
            .build());
        responseObserver.onCompleted();
    }
}
