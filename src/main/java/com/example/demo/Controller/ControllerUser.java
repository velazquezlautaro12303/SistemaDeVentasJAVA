package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Repository.RepoUser;
import com.example.demo.View.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
public class ControllerUser {

    @Autowired
    private RepoUser repoUser;

    @DeleteMapping(path = "user/{id}")
    public @ResponseBody ResponseEntity<User> updateUser(@PathVariable("id") Integer id){
        Optional<User> userOptional = this.repoUser.findById(id);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            user.setAvailable(Boolean.FALSE);
            this.repoUser.save(user);
            return ResponseEntity.ok(user);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "user/{id}")
    public UserView getUser(@PathVariable("id") Integer id){
        return repoUser.findUserById(id);
    }

    @PostMapping(path = "user/{id}")
    public User updateUser(@PathVariable("id") Integer id, @RequestBody User user){
        User user1 = repoUser.findById(id).get();
        user1.setNameUser(user.getNameUser());
        user1.setAvailable(user.getAvailable());
        user1.setPassword(user.getPassword());
        return repoUser.save(user1);
    }

    @PostMapping(path = "login")
    public @ResponseBody ResponseEntity<User> login(@RequestBody User user){
        User user1 = this.repoUser.getUserByNameUserAndPasswordAndAvailableTrue(user.getNameUser(), user.getPassword());
        if(user1 != null){
            return ResponseEntity.ok(user1);
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }

}
