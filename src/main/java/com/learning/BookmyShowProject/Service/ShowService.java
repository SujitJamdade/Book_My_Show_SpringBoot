package com.learning.BookmyShowProject.Service;

import com.learning.BookmyShowProject.Models.Movie;
import com.learning.BookmyShowProject.Models.Show;
import com.learning.BookmyShowProject.Models.Theater;
import com.learning.BookmyShowProject.Repository.MovieRepository;
import com.learning.BookmyShowProject.Repository.ShowRepository;
import com.learning.BookmyShowProject.Repository.TheaterRepository;
import com.learning.BookmyShowProject.RequestDTOs.AddShowRequest;
import com.learning.BookmyShowProject.Transformers.ShowTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    public String addShow(AddShowRequest addShowRequst){

        // setting show Entity to store in db;

        Show show = ShowTransformer.convertAddShowRequestToShowEntity(addShowRequst);

        Movie movie = movieRepository.findMovieByMovieName(addShowRequst.getMovieName());

        Optional<Theater> optionalTheater = theaterRepository.findById(addShowRequst.getTheaterId());

        Theater theater = optionalTheater.get();

        // Setting FK Value
        // Show having FK as theater and movie
        show.setMovie(movie);
        show.setTheater(theater);

        // Setting the bidirectional value
        theater.getShowList().add(show);
        movie.getShowList().add(show);

        // Here show is child element of the Movie and Theater
        // Movie and theater are parent
        // So saving only show so it can cascade to the parent element
        show = showRepository.save(show);

        return "Show has been saved to the DB with show ID : " + show.getShowId();

    }

}
