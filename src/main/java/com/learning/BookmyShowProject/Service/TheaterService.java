package com.learning.BookmyShowProject.Service;

import com.learning.BookmyShowProject.Enums.SeatType;
import com.learning.BookmyShowProject.Models.Theater;
import com.learning.BookmyShowProject.Models.TheaterSeat;
import com.learning.BookmyShowProject.Repository.TheaterRepository;
import com.learning.BookmyShowProject.RequestDTOs.AddTheaterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;
    public String addTheater(AddTheaterRequest addTheaterRequest) {

        // Create the theater entity

        Theater theater = Theater.builder()
                        .name(addTheaterRequest.getName())
                        .address(addTheaterRequest.getAddress())
                        .city(addTheaterRequest.getCity())
                        .build();

        // Create theater_seat entity
        createTheaterSeats(theater,addTheaterRequest);

        return "Theater and its seats have been saved to DB";

    }

    private void createTheaterSeats(Theater theater, AddTheaterRequest addTheaterRequest) {

        int noOfClassicSeats = addTheaterRequest.getNoOfClassicSeats();
        int noOfPremiumSeats = addTheaterRequest.getNoOfPremiumSeats();
        int seatsPerRow = addTheaterRequest.getNoOfSeatsPerRow();

        // Create Primary Seat Entity
        List<TheaterSeat> theaterSeatList = new ArrayList<>();

        int row = 0;
        char ch = 'A';


        // for classic seat
        for(int i = 1;i<=noOfClassicSeats;i++){

            if(i%seatsPerRow==1){
                row++;
                ch = 'A';
            }

            String seatNo = row + "" + ch;
            ch++;

            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.CLASSIC)
                    .theater(theater)
                    .build();

            theaterSeatList.add(theaterSeat);
        }

        //Similar numbering I will do for the Premium Seats :

        ch = 'A';

        for(int i = 1; i<=noOfPremiumSeats; i++){

            if(i%seatsPerRow==1){
                row++;
                ch = 'A';
            }

            String seatNo = row + "" + ch;
            ch++;

            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.PREMIUM)
                    .theater(theater)
                    .build();

            theaterSeatList.add(theaterSeat);
        }

        // Bi-directional Mapping >> Theater Having list of seats
        theater.setTheaterSeatList(theaterSeatList);

        theaterRepository.save(theater);

    }
}
