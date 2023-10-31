package com.learning.BookmyShowProject.Transformers;

import com.learning.BookmyShowProject.Models.User;
import com.learning.BookmyShowProject.RequestDTOs.AddUserRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;


public class UserTransformer {

    public static User convertAddUserRequestToUserEntity(AddUserRequest addUserRequest){

        User userObject = User.builder()
                .age(addUserRequest.getAge())
                .email(addUserRequest.getEmail())
                .name(addUserRequest.getName())
                .mobNo(addUserRequest.getMobNo())
                .build();

        return  userObject;

    }

}
