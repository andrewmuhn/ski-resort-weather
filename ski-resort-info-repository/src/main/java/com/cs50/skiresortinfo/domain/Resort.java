package com.cs50.skiresortinfo.domain;

public record Resort(String slug, String name, String country, String region, String url, double latitude, double longitude) {
    public Resort {
        filled(slug);
        filled(name);
        filled(country);
        filled(region);
        filled(url);
    }

    private static void filled(String s) {
        if(s == null || s.isBlank()) {
            throw new IllegalArgumentException("No value present!");
        }
    }
}
