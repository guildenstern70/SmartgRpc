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
import net.littlelite.HypotenuseGrpc;
import net.littlelite.HypotenuseReply;
import net.littlelite.TriangleRequest;
import net.littlelite.service.TriangleService;

import javax.inject.Inject;

@GrpcService
public class HypotenuseService implements HypotenuseGrpc
{
    @Inject
    TriangleService triangleService;

    @Override
    public Uni<HypotenuseReply> hypotenuseService(TriangleRequest request)
    {
        var hypotenuse = this.triangleService.getHypotenuse(request.getLeg1(), request.getLeg2());
        var reply = HypotenuseReply.newBuilder().setHypotenuse(hypotenuse).build();
        return Uni.createFrom().item(reply);
    }
}
