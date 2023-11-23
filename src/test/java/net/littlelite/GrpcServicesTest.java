/*
 *
 * Project SmartgRpc
 * Copyright (C) 2022-23 Alessio Saltarin
 *
 * This software is licensed under MIT License (see LICENSE)
 *
 */

package net.littlelite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class GrpcServicesTest
{
    @GrpcClient
    Md5Grpc md5Grpc;

    @GrpcClient
    HypotenuseGrpc hypotenuseGrpc;

    private static final Duration TIMEOUT = Duration.ofSeconds(2);

    @Test
    public void testMd5gRpc()
    {
        var request = Md5Request.newBuilder().setStringToHash("Alessio").build();
        var reply = this.md5Grpc.md5Service(request).await().atMost(TIMEOUT);
        assertEquals("3ukn4ozDlWewQRfYHToEww==", reply.getHashCode());
    }

    @Test
    public void testHypotenuseRpc()
    {
        var request = TriangleRequest.newBuilder()
                .setLeg1(12.2)
                .setLeg2(4.56)
                .build();
        var reply = this.hypotenuseGrpc.hypotenuseService(request).await().atMost(TIMEOUT);
        assertEquals(13.024346432738955, reply.getHypotenuse());
    }

}
