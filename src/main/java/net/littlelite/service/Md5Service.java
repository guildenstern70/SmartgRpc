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
import org.jetbrains.annotations.NotNull;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@ApplicationScoped
public class Md5Service
{
    public String generateMd5(@NotNull String message)
    {
        String b64Digest = "?";
        try
        {
            var md = MessageDigest.getInstance("MD5");
            md.update(message.getBytes());
            var digest = md.digest();
            b64Digest = Base64.getEncoder().encodeToString(digest);
        }
        catch (NoSuchAlgorithmException ignored) {}
        return b64Digest;

    }
}
