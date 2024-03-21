package com.cs50.skiresortinfo.server;

import com.cs50.skiresortinfo.repository.ResortsRepository;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;
import java.util.logging.LogManager;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

public class SkiResortServer {
    static {
        LogManager.getLogManager().reset();
        SLF4JBridgeHandler.install();
    }

    private static final Logger LOG = LoggerFactory.getLogger(SkiResortServer.class);

    private static final String BASE_URI = "http://localhost:8080/";

    public static void main(String... args) {
        String baseUri = loadBaseUri();
        LOG.info("Starting HTTP Ski-Resort-Server");
        ResortsRepository resortsRepository = ResortsRepository.openResortsRepository();
        ResourceConfig config = new ResourceConfig().register(new ResortResource(resortsRepository));
        GrizzlyHttpServerFactory.createHttpServer(URI.create(baseUri), config);
    }

    private static String loadBaseUri() {
        try (InputStream propertiesStream =
                     SkiResortServer.class.getResourceAsStream("/server.properties")) {
            Properties properties = new Properties();
            properties.load(propertiesStream);
            return properties.getProperty("ski-resort-info.base-uri");
        } catch (IOException e) {
            throw new IllegalStateException("Could not load base URI");
        }
    }
}