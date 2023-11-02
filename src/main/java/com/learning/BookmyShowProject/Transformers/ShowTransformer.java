package com.learning.BookmyShowProject.Transformers;

import com.learning.BookmyShowProject.Models.Show;
import com.learning.BookmyShowProject.RequestDTOs.AddShowRequest;

public class ShowTransformer {

    public static Show convertAddShowRequestToShowEntity(AddShowRequest addShowRequst){

        Show showObj = Show.builder()
                .showDate(addShowRequst.getShowDate())
                .showTime(addShowRequst.getShowTime())
                .build();

        return showObj;
    }
}
