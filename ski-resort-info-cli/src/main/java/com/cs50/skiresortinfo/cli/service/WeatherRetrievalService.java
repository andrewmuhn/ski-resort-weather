package com.cs50.skiresortinfo.cli.service;

import com.cs50.skiresortinfo.cli.utils.GetSecret;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;


public class WeatherRetrievalService {

    private static final String WEATHER_URI = GetSecret.getSecret("open-weather-map.api-url");
    private static final String WEATHER_API_KEY = GetSecret.getSecret("open-weather-map.api-key");

    private static final String UNITS = "imperial";

    private static final HttpClient CLIENT = HttpClient
            .newBuilder()
            .followRedirects(HttpClient.Redirect.ALWAYS)
            .build();

    private HttpRequest buildRequest(String uri) {
        return HttpRequest
                .newBuilder(URI.create(uri))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
    }

    public JsonObject getCurrentWeather(double latitude, double longitude) {
        URI uri = URI.create(String.format("%sweather?lat=%s&lon=%s&appid=%s&units=%s", WEATHER_URI, latitude, longitude, WEATHER_API_KEY, UNITS));
        HttpRequest request = buildRequest(uri.toString());

        try {
            HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                try (JsonReader jsonReader = Json.createReader(new StringReader(response.body()))) {
                    return jsonReader.readObject();
                }
            } else {
                throw new RuntimeException("OpenWeatherMap API call failed with status code " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public JsonObject get5dayWeather(double latitude, double longitude) {
        URI uri = URI.create(String.format("%sforecast?lat=%s&lon=%s&appid=%s&units=%s", WEATHER_URI, latitude, longitude, WEATHER_API_KEY, UNITS));
        HttpRequest request = buildRequest(uri.toString());

        try {
            HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                try (JsonReader jsonReader = Json.createReader(new StringReader(response.body()))) {
                    return jsonReader.readObject();
                }
            } else {
                throw new RuntimeException("OpenWeatherMap API call failed with status code " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
