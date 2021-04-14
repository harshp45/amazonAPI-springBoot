package com.example.AmazonAPI.services;

import com.example.AmazonAPI.models.User;
import com.example.AmazonAPI.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getUsers()
    {
        return repository.findAll();
    }

    public void insertIntoUser(User user)
    {
        repository.insert(user);
    }

    public Optional<User> getAUser(String id)
    {
        return repository.findById(id);
    }

    public void deleteAUser(String id)
    {
        repository.deleteById(id);
    }
}
