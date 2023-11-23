/*
 *
 * Project SmartgRpc
 * Copyright (C) 2022-23 Alessio Saltarin
 *
 * This software is licensed under MIT License (see LICENSE)
 *
 */

package net.littlelite.service;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import net.littlelite.config.SmartgRpcConfig;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

@ApplicationScoped
public class StartupService
{
    @Inject
    Logger logger;

    @Inject
    SmartgRpcConfig smartgRpcConfig;

    private void hello()
    {
        var version = smartgRpcConfig.version();
        logger.info("*****************************************************************");
        logger.info("  Smart gRPC v." + version);
        logger.info("  JVM: " + System.getProperty("java.vendor") + " " + System.getProperty("java.version"));
        logger.info("  Listening on: http://localhost:8080");
        logger.info("*****************************************************************");
    }

    void onStart(@Observes StartupEvent ev)
    {
        logger.info("Smart gRPC is starting...");
        hello();
    }

    void onStop(@Observes ShutdownEvent ev) {
        logger.info("Smart gRPC stopping...");
    }
}
