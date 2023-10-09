package com.exemplo.grpcserver.service;

import java.util.List;

import com.exemplo.proto.Animal;
import com.exemplo.proto.FindByIdRequest;
import com.exemplo.proto.FindByIdResponse;
import com.exemplo.proto.Raca;
import com.exemplo.proto.PessoaServiceGrpc.PessoaServiceImplBase;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class PessoaService extends PessoaServiceImplBase {

    @Override
    public void findById(FindByIdRequest request, StreamObserver<FindByIdResponse> responseObserver){
	Animal animal = Animal.newBuilder()
	    .setNome("Theo")
	    .setIdade(100)
	    .setRaca(Raca.DOBERMANN)
	    .build();
	
	FindByIdResponse response = FindByIdResponse.newBuilder()
	    .setId(request.getId())
	    .setNome("Romulo")
	    .setSobrenome("Souza")
	    .setVivo(true)
	    .addAllAnimais(List.of(animal))
	    .build();
	responseObserver.onNext(response);
	responseObserver.onCompleted();
    }
}
