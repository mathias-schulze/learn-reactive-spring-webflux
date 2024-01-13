package com.reactivespring.service;

import com.reactivespring.domain.MovieInfo;
import com.reactivespring.repository.MovieInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class MovieInfoService {

    private MovieInfoRepository movieInfoRepository;

    public Mono<MovieInfo> addMovieInfo(MovieInfo movieInfo) {

        return movieInfoRepository.save(movieInfo);
    }
}
