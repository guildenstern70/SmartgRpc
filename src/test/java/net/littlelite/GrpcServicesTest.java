/*
 *
 * Project SmartgRpc
 * Copyright (C) 2022 Alessio Saltarin
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

    @Test
    public void testMd5gRpc()
    {
        var request = Md5Request.newBuilder().setStringToHash("Alessio").build();
        var reply = this.md5Grpc.md5Service(request).await().atMost(Duration.ofSeconds(5));
        assertEquals("3ukn4ozDlWewQRfYHToEww==", reply.getHashCode());
    }

}
