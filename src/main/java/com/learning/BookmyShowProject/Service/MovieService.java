package com.learning.BookmyShowProject.Service;

import com.learning.BookmyShowProject.Models.Movie;
import com.learning.BookmyShowProject.Repository.MovieRepository;
import com.learning.BookmyShowProject.RequestDTOs.AddMovieRequest;
import com.learning.BookmyShowProject.Transformers.MovieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public String addMovie(AddMovieRequest addMovieRequest) throws Exception{

        Movie movie = MovieTransformer.convertAddMovieRequestToMovieEntity(addMovieRequest);

        movieRepository.save(movie);

        return "Movie has been added into the DB " + movie.getMovieName();
    }
}
