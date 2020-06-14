package com.example.beerservice.repo;

import com.example.beerservice.Beer;

import java.util.List;
import java.util.concurrent.Future;

public interface BeerRepo {
    Future<List<Beer>> getAll();
}
