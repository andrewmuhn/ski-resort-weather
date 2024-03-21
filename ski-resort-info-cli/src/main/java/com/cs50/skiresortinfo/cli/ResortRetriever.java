package com.cs50.skiresortinfo.cli;

import com.cs50.skiresortinfo.cli.service.ApiResort;
import com.cs50.skiresortinfo.cli.service.ResortRetrievalService;
import com.cs50.skiresortinfo.cli.service.ResortsStorageService;
import com.cs50.skiresortinfo.repository.ResortsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ResortRetriever {
    private static final Logger LOG = LoggerFactory.getLogger(ResortRetriever.class);

    public static void main(String... args) {
        LOG.info("ResortRetriever starting!");
        if (args.length == 0) {
            try {
                retrieveAllResorts();
            } catch (Exception e) {
                LOG.error("Unexpected error", e);
            }
        }
    }


    private static void retrieveAllResorts() {
        LOG.info("Retrieving all resorts");
        ResortRetrievalService resortRetrievalService = new ResortRetrievalService();
        ResortsRepository resortsRepository = ResortsRepository.openResortsRepository();
        ResortsStorageService resortsStorageService = new ResortsStorageService(resortsRepository);

        List<ApiResort> resortsToStore = resortRetrievalService.getAllResorts();
        LOG.info("Retrieved the following resorts {}", resortsToStore);
        System.out.println(resortsToStore.getClass());
        resortsStorageService.storeResorts(resortsToStore);
    }
}
