package com.example.gateway.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("v1/beers")
public class BeersController {
    private BeerRepo repo;

    public BeersController(BeerRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Beer> beers() throws ExecutionException, InterruptedException {
        return repo.getAll().get();
    }
}
