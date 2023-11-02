package com.learning.BookmyShowProject.Transformers;

import com.learning.BookmyShowProject.Models.Movie;
import com.learning.BookmyShowProject.RequestDTOs.AddMovieRequest;

public class MovieTransformer {

    public static Movie convertAddMovieRequestToMovieEntity(AddMovieRequest addMovieRequest){

        Movie movieObj = Movie.builder()
                .movieName(addMovieRequest.getMovieName())
                .genre(addMovieRequest.getGenre())
                .rating(addMovieRequest.getRating())
                .releaseDate(addMovieRequest.getReleaseDate())
                .build();

        return movieObj;
    }
}
