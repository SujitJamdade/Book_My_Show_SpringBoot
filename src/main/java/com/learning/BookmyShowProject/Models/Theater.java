package com.learning.BookmyShowProject.Models;

import com.learning.BookmyShowProject.Enums.City;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theater")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String address;

    @Enumerated(value = EnumType.STRING)
    private City city;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private List<TheaterSeat> theaterSeatList = new ArrayList<>();

}