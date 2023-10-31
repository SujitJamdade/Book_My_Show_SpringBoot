package com.learning.BookmyShowProject.Service;


import com.learning.BookmyShowProject.Models.User;
import com.learning.BookmyShowProject.Repository.UserRepository;
import com.learning.BookmyShowProject.RequestDTOs.AddUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(AddUserRequest addUserRequest){

        // I need to create the User Object
        // ans save it to the DB.

//        User user = new User();
//        user.setName(addUserRequest.getName());
//        user.setAge(addUserRequest.getAge());
//        user.setEmail(addUserRequest.getEmail());
//        user.setMobNo(addUserRequest.getMobNo());

        // Builder object
        User userObject = User.builder()
                .age(addUserRequest.getAge())
                .email(addUserRequest.getEmail())
                .name(addUserRequest.getName())
                .mobNo(addUserRequest.getMobNo())
                .build();

        userRepository.save(userObject);

        return "User Added Successfully";
    }
}
