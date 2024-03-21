package com.cs50.skiresortinfo.cli.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiResort(String slug, String name, String country, String region, String url, ApiLocation location) {
}