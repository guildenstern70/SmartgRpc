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
import org.junit.jupiter.api.Test;
import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class ServicesTest
{
    @Inject
    Md5Service md5Service;

    @Test
    public void testMd5Service()
    {
        var hash = this.md5Service.generateMd5("Alessio");
        assertThat(hash).isEqualTo("3ukn4ozDlWewQRfYHToEww==");
    }
}
