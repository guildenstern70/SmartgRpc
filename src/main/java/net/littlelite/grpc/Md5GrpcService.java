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
import net.littlelite.Md5Grpc;
import net.littlelite.Md5Reply;
import net.littlelite.Md5Request;
import net.littlelite.service.Md5Service;

import javax.inject.Inject;

@GrpcService
public class Md5GrpcService implements Md5Grpc
{
    @Inject
    Md5Service md5Service;

    @Override
    public Uni<Md5Reply> md5Service(Md5Request request)
    {
        var hash = this.md5Service.generateMd5(request.getStringToHash());
        return Uni.createFrom().item(request.getStringToHash())
                .map(msg -> Md5Reply.newBuilder().setHashCode(hash).build());
    }
}
