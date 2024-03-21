package com.cs50.skiresortinfo.cli.service;

import com.cs50.skiresortinfo.cli.utils.GetSecret;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ResortRetrievalService {

    private static final String RESORT_URI = "https://ski-resorts-and-conditions.p.rapidapi.com/v1/%s";
    private static final String RESORT_API_KEY = GetSecret.getSecret("ski-resort-info.resort-api-key");
    private static final String RESORT_API_HOST = GetSecret.getSecret("ski-resort-info.resort-api-host");

    private static final HttpClient CLIENT = HttpClient
            .newBuilder()
            .followRedirects(HttpClient.Redirect.ALWAYS)
            .build();

    private HttpRequest buildRequest(String uri) {
        return HttpRequest
                .newBuilder(URI.create(uri))
                .header("x-rapidapi-key", RESORT_API_KEY)
                .header("x-rapidapi-host", RESORT_API_HOST)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
    }

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public List<ApiResort> getAllResorts() {
        HttpRequest request = buildRequest(RESORT_URI.formatted("resort"));
        return sendRequest(request);
    }

    private List<ApiResort> sendRequest(HttpRequest request) {
        try {
            HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            return switch (response.statusCode()) {
                case 200 -> toResorts(response);
                case 404 -> List.of();
                default ->
                        throw new RuntimeException("SkiResort API call failed with status code " + response.statusCode());
            };
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Could not call Resort API", e);
        }
    }

    private static List<ApiResort> toResorts(HttpResponse<String> response) throws JsonProcessingException {
        JsonNode rootNode = OBJECT_MAPPER.readTree(response.body());
        JsonNode dataNode = rootNode.get("data");

        JavaType returnType = OBJECT_MAPPER.getTypeFactory()
                .constructCollectionType(List.class, ApiResort.class);
        try {
            return OBJECT_MAPPER.readValue(dataNode.traverse(), returnType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
