package com.cs50.skiresortinfo.cli.utils;

import com.cs50.skiresortinfo.cli.service.ResortRetrievalService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetSecret {
    public static String getSecret(String secret) {
        try (InputStream propertiesStream =
                     ResortRetrievalService.class.getResourceAsStream("/config.properties")) {
            Properties properties = new Properties();
            properties.load(propertiesStream);
            return properties.getProperty(secret);
        } catch (IOException e) {
            throw new IllegalStateException("Could not load api key");
        }
    }
}
