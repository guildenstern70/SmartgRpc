/*
 *
 * Project SmartgRpc
 * Copyright (C) 2022-23 Alessio Saltarin
 *
 * This software is licensed under MIT License (see LICENSE)
 *
 */

package net.littlelite.config;


import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "smartgrpc")
public interface SmartgRpcConfig
{
    String version();
}
