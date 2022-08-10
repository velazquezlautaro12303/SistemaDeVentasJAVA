package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Repository.RepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
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

    @PostMapping(path = "login")
    public @ResponseBody ResponseEntity<User> login(@RequestBody User user){
        User user1 = this.repoUser.getUserByNameUserAndPassword(user.getNameUser(), user.getPassword());
        if(user1 != null){
            return ResponseEntity.ok(user1);
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }

}
