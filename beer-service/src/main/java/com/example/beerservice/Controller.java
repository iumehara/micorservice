package com.example.beerservice;

import com.example.beerservice.repo.BeerRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class Controller {
    private BeerRepo beerRepo;

    public Controller(BeerRepo beerRepo) {
        this.beerRepo = beerRepo;
    }

    @GetMapping
    public List<Beer> getAll() throws ExecutionException, InterruptedException {
        return beerRepo.getAll().get();
    }
}
