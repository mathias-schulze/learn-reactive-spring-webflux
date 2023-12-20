package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoGeneratorService {

    public Flux<String> namesFlux() {
        return Flux.fromIterable(List.of("Anton", "Bertram", "Claudia")).log();
    }

    public Flux<String> namesFluxMap() {
        return Flux.fromIterable(List.of("Anton", "Bertram", "Claudia")).map(String::toUpperCase).log();
    }

    public Mono<String> nameMono() {
        return Mono.just("Daniel");
    }
    public static void main(String[] args) {

        FluxAndMonoGeneratorService service = new FluxAndMonoGeneratorService();
        service.namesFlux().subscribe(name -> System.out.println("Flux name is: " + name));
        service.nameMono().subscribe(name -> System.out.println("Mono name is: " + name));
    }
}
