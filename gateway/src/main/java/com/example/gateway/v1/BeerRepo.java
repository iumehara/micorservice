package com.example.gateway.v1;

import java.util.List;
import java.util.concurrent.Future;

public interface BeerRepo {
    Future<List<Beer>> getAll();
}
