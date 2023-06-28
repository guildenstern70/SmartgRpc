/*
 *
 * Project SmartgRpc
 * Copyright (C) 2022 Alessio Saltarin
 *
 * This software is licensed under MIT License (see LICENSE)
 *
 */

package net.littlelite;

import io.quarkus.test.junit.QuarkusTest;
import net.littlelite.service.Md5Service;
import net.littlelite.service.TriangleService;
import org.junit.jupiter.api.Test;
import jakarta.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class ServicesTest
{
    @Inject
    Md5Service md5Service;

    @Inject
    TriangleService triangleService;

    @Test
    public void testMd5Service()
    {
        var hash = this.md5Service.generateMd5("Alessio");
        assertThat(hash).isEqualTo("3ukn4ozDlWewQRfYHToEww==");
    }

    @Test
    public void testTriangleService()
    {
        var hypotenuse = this.triangleService.getHypotenuse(12.2, 3.9);
        assertThat(hypotenuse).isEqualTo(12.808200498118383);
    }
}
