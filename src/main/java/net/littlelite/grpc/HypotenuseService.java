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
import org.jboss.logging.Logger;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

@GrpcService
public class HypotenuseService implements HypotenuseGrpc
{
    @Inject
    Logger log;

    @Inject
    TriangleService triangleService;

    @Override
    public Uni<HypotenuseReply> hypotenuseService(@NotNull TriangleRequest request)
    {
        log.info("Called gRPC HypotenuseService");
        log.info("Leg1 = " + request.getLeg1());
        log.info("Leg2 = " + request.getLeg2());
        var hypotenuse = this.triangleService.getHypotenuse(request.getLeg1(), request.getLeg2());
        log.info("gRpc Response => Hypotenuse = " + hypotenuse);
        var reply = HypotenuseReply.newBuilder().setHypotenuse(hypotenuse).build();
        return Uni.createFrom().item(reply);
    }
}
