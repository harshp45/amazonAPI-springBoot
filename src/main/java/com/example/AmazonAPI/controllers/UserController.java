package com.example.AmazonAPI.controllers;

import com.example.AmazonAPI.CustomizedResponse;
import com.example.AmazonAPI.models.User;
import com.example.AmazonAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public ResponseEntity getUsers()
    {
        var customizedResponse = new CustomizedResponse("List of all users",service.getUsers());
        return new ResponseEntity(customizedResponse,HttpStatus.OK);
    }


    @GetMapping("/users/{id}")
    public ResponseEntity getAUser(@PathVariable("id") String id)
    {

        var customizedResponse = new CustomizedResponse("User with id :"+id, Collections.singletonList(service.getAUser(id)));

        return new ResponseEntity(customizedResponse,HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteAUser(@PathVariable("id") String id)
    {
        service.deleteAUser(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/users",consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity addUser(@RequestBody User user)
    {

        service.insertIntoUser(user);

        return new ResponseEntity(user,HttpStatus.OK);

    }

}
