package com.yt.graphql.services;

import com.yt.graphql.entities.User;
import com.yt.graphql.helper.ExceptionHelper;
import com.yt.graphql.repositories.UserRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    //creating user
    public User creatingUser(User user)
    {
        return (User) userRepo.save(user);
    }
    //getting all user
    public List<User> getAllUser()
    {
        return userRepo.findAll();
    }
    //getting single user
    public User getUser(int userId) {
      User user = userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
       return user;
    }
    //updating user
//    public User updateUser(User user, int userId)
//    {
//        Optional user1 = userRepo.findById(userId);
//        user1.isPresent()
//
//    }
    //deleting user
    public boolean deleteUser(int userId)
    {
        User user = userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        userRepo.delete(user);
        return true;
    }
}
