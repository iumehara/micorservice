package com.example.gateway.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.Future;

import static java.util.Arrays.asList;
import static java.util.Objects.requireNonNull;
import static java.util.concurrent.CompletableFuture.completedFuture;

@Repository
public class BeerRepoNetwork implements BeerRepo {

    @Async
    @Override
    public Future<List<Beer>> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        String beerServiceUrl = "http://localhost:8081";
        ResponseEntity<Beer[]> response = restTemplate.getForEntity(beerServiceUrl, Beer[].class);
        List<Beer> beers = asList(requireNonNull(response.getBody()));
        return completedFuture(beers);
    }
}
