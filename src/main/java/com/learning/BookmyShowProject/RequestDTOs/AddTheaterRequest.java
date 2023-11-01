package com.learning.BookmyShowProject.RequestDTOs;


import com.learning.BookmyShowProject.Enums.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.TinyIntAsSmallIntJdbcType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddTheaterRequest {

    private String name;
    private String address;
    private City city;
    private Integer noOfClassicSeats;
    private Integer noOfPremiumSeats;
    private Integer noOfSeatsPerRow;

}
