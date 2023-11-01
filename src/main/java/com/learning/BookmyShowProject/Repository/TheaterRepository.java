package com.learning.BookmyShowProject.Repository;

import com.learning.BookmyShowProject.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater,Integer> {


}
