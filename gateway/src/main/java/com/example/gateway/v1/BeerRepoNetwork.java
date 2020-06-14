package com.example.gateway.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.Arrays.asList;
import static java.util.Objects.requireNonNull;

@Repository
public class BeerRepoNetwork implements BeerRepo {

    @Override
    public Future<List<Beer>> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        CompletableFuture<List<Beer>> beersFuture = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(() -> {
            String beerServiceUrl = "http://localhost:8081";
            ResponseEntity<Beer[]> response = restTemplate.getForEntity(beerServiceUrl, Beer[].class);
            List<Beer> beers = asList(requireNonNull(response.getBody()));
            beersFuture.complete(beers);
        });

        return beersFuture;
    }
}
