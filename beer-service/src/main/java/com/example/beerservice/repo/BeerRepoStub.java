package com.example.beerservice.repo;

import com.example.beerservice.Beer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.Future;

import static java.util.Arrays.asList;
import static java.util.concurrent.CompletableFuture.completedFuture;

@Repository
public class BeerRepoStub implements BeerRepo {
    @Override
    public Future<List<Beer>> getAll() {
        return completedFuture(asList(
                new Beer(1, "Yebisu"),
                new Beer(2, "Ebisu")
        ));
    }
}
