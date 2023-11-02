package com.learning.BookmyShowProject.Controller;

import com.learning.BookmyShowProject.RequestDTOs.AddShowRequest;
import com.learning.BookmyShowProject.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("show")
public class ShowController {


    @Autowired
    private ShowService showService;

    @PostMapping("/addShow")
    public String addShow(@RequestBody AddShowRequest addShowRequest){

        String result = showService.addShow(addShowRequest);
        return result;
    }
}
