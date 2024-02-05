package com.reactivespring.controller;

import com.reactivespring.domain.MovieInfo;
import com.reactivespring.service.MovieInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1")
public class MoviesInfoController {

    private MovieInfoService moviesInfoService;

    public MoviesInfoController(MovieInfoService moviesInfoService) {
        this.moviesInfoService = moviesInfoService;
    }

    @GetMapping("/movieinfos")
    public Flux<MovieInfo> getAllMovieInfos(){
        return moviesInfoService.getAllMovieInfos().log();
    }

    @GetMapping("/movieinfos/{id}")
    public Mono<MovieInfo> getMovieInfoById(@PathVariable String id){
        return moviesInfoService.getMovieInfoById(id);
    }

    @PostMapping("/movieinfos")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<MovieInfo> addMovieInfo(@RequestBody MovieInfo movieInfo){
        return moviesInfoService.addMovieInfo(movieInfo).log();

    }

    @PutMapping("/movieinfos/{id}")
    public Mono<MovieInfo> updateMovieInfo(@RequestBody MovieInfo updatedMovieInfo, @PathVariable String id){
        return moviesInfoService.updateMovieInfo(updatedMovieInfo, id);

    }

    @DeleteMapping("/movieinfos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteMovieInfo(@PathVariable String id){
        return moviesInfoService.deleteMovieInfo(id);

    }
}
