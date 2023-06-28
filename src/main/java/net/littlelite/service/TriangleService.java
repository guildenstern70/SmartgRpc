/*
 *
 * Project SmartgRpc
 * Copyright (C) 2022 Alessio Saltarin
 *
 * This software is licensed under MIT License (see LICENSE)
 *
 */

package net.littlelite.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TriangleService
{
    public double getHypotenuse(double adjacent, double opposite)
    {
        return Math.sqrt((adjacent*adjacent)+(opposite*opposite));
    }
}
