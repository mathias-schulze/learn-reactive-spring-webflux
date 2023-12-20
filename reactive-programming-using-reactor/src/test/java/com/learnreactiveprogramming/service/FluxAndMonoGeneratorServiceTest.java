package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class FluxAndMonoGeneratorServiceTest {

    FluxAndMonoGeneratorService service = new FluxAndMonoGeneratorService();

    @Test
    void namesFlux() {

        Flux<String> namesFlux = service.namesFlux();

        StepVerifier.create(namesFlux)
                //.expectNext("Anton", "Bertram", "Claudia")
                //.expectNextCount(3)
                .expectNext("Anton")
                .expectNextCount(2)
                .verifyComplete();
    }

    @Test
    void namesFluxMap() {

        Flux<String> namesFluxMap = service.namesFluxMap();

        StepVerifier.create(namesFluxMap)
                .expectNext("ANTON", "BERTRAM", "CLAUDIA")
                .verifyComplete();
    }
}