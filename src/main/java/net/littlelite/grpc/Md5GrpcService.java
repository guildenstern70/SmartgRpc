/*
 *
 * Project SmartgRpc
 * Copyright (C) 2022 Alessio Saltarin
 *
 * This software is licensed under MIT License (see LICENSE)
 *
 */

package net.littlelite.grpc;

import io.quarkus.grpc.GrpcService;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import net.littlelite.Md5Grpc;
import net.littlelite.Md5Reply;
import net.littlelite.Md5Request;
import net.littlelite.service.Md5Service;
import org.jboss.logging.Logger;
import org.jetbrains.annotations.NotNull;


@GrpcService
public class Md5GrpcService implements Md5Grpc
{
    @Inject
    Logger log;

    @Inject
    Md5Service md5Service;

    @Override
    public Uni<Md5Reply> md5Service(@NotNull Md5Request request)
    {
        log.info("Received request for gRPC Md5Service");
        log.info("Md5Request  = " + request.getStringToHash());
        var hash = this.md5Service.generateMd5(request.getStringToHash());
        log.info("Md5Response = " + hash);
        return Uni.createFrom().item(request.getStringToHash())
                .map(msg -> Md5Reply.newBuilder().setHashCode(hash).build());
    }
}
