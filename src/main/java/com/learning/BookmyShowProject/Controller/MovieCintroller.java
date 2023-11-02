package com.learning.BookmyShowProject.Controller;

import com.learning.BookmyShowProject.RequestDTOs.AddMovieRequest;
import com.learning.BookmyShowProject.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movie")
public class MovieCintroller {

    @Autowired
    private MovieService movieService;

    @PostMapping("/addMovie")
    public ResponseEntity addMovie(@RequestBody AddMovieRequest addMovieRequest){

        try{
            String response = movieService.addMovie(addMovieRequest);
            return new ResponseEntity(response, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }
}
