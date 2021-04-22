package com.example.AmazonAPI.controllers;

import com.example.AmazonAPI.CustomizedResponse;
import com.example.AmazonAPI.models.User;
import com.example.AmazonAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@CrossOrigin
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

    @PostMapping(value = "/users/login",consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity loginUser(@RequestBody User user)
    {
        var customizedResponse = service.loginUser(user.getEmail());
        String hashPass = customizedResponse.getPassword();
        String currentPass = user.getPassword();
        if(BCrypt.checkpw(currentPass, hashPass))
        {
            System.out.print("\nPassword Matched"+HttpStatus.OK);
            return new ResponseEntity(customizedResponse, HttpStatus.OK);
        }
        else
        {
            System.out.print("\nPassword Not Matched"+HttpStatus.FORBIDDEN);
            return new ResponseEntity("Incorrect Password", HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteAUser(@PathVariable("id") String id)
    {
        service.deleteAUser(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/users/register",consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity addUser(@RequestBody User user)
    {
        String encodePassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(encodePassword);
        service.insertIntoUser(user);
        return new ResponseEntity(user,HttpStatus.OK);
    }

}
