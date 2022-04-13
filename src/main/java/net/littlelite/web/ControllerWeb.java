/*
 *
 * Project SmartgRpc
 * Copyright (C) 2022 Alessio Saltarin
 *
 * This software is licensed under MIT License (see LICENSE)
 *
 */

package net.littlelite.web;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import net.littlelite.config.SmartgRpcConfig;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class ControllerWeb
{
    @Inject
    Template index;

    @Inject
    SmartgRpcConfig config;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance homePage()
    {
        return this.index.data("version", config.version());
    }

}