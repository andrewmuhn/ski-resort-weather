package com.cs50.skiresortinfo.server;

import com.cs50.skiresortinfo.domain.Resort;
import com.cs50.skiresortinfo.repository.ResortsRepository;
import com.cs50.skiresortinfo.repository.RepositoryException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.stream.Stream;

@Path("/resorts")
public class ResortResource {

    private static final Logger LOG = LoggerFactory.getLogger(ResortResource.class);
    private final ResortsRepository resortsRepository;
    public ResortResource(ResortsRepository resortsRepository) {this.resortsRepository = resortsRepository; }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Stream<Resort> getResorts() {
        try {
            return resortsRepository
                    .getAllResorts()
                    .stream()
                    .sorted(Comparator.comparing(Resort::slug));
        } catch (RepositoryException e) {
            LOG.error("Failed to retrieve resorts from the database", e);
            throw new NotFoundException();
        }
    }

}
