package com.cs50.skiresortinfo.cli.service;

import com.cs50.skiresortinfo.domain.Resort;
import com.cs50.skiresortinfo.repository.ResortsRepository;

import java.util.List;

public class ResortsStorageService {
    private final ResortsRepository resortsRepository;

    public ResortsStorageService(ResortsRepository resortsRepository) {
        this.resortsRepository = resortsRepository;
    }

    public void storeResorts(List<ApiResort> resorts) {
        System.out.println("ResortsStorageService - Resorts to Store:");
        for (ApiResort apiResort : resorts) {
            System.out.println(apiResort);
            Resort resort = new Resort(apiResort.slug(),
                    apiResort.name(), apiResort.country(),
                    apiResort.region(), apiResort.url(),
                    apiResort.location().latitude(), apiResort.location().longitude());
            resortsRepository.saveResort(resort);
        }
    }

}
