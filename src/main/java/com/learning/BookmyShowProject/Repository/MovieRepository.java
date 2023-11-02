package com.learning.BookmyShowProject.Repository;

import com.learning.BookmyShowProject.Models.Movie;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Movie findMovieByMovieName(String movieName);
}
