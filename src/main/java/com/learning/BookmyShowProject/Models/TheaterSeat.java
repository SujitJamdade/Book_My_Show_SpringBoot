package com.learning.BookmyShowProject.Models;

import com.learning.BookmyShowProject.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "theater_seat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TheaterSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterId;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn
    private Theater theater;
}
