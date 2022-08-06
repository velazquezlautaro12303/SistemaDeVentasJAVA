//package com.example.demo.Controller;
//
//import com.example.demo.Entity.User;
//import com.example.demo.Repository.RepoUser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.rest.webmvc.RepositoryRestController;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RepositoryRestController
//@CrossOrigin
//public class ControllerUser {
//
//    @Autowired
//    private RepoUser user;
//
//    @DeleteMapping(path = "user/{id}")
//    public @ResponseBody ResponseEntity<User> updateUser(@PathVariable("id") Integer id){
//        Optional<User> userOptional = this.user.findById(id);
//        if (userOptional.isPresent()){
//            User user = userOptional.get();
//            user.setAvailable(Boolean.FALSE);
//            this.user.save(user);
//            return ResponseEntity.ok(user);
//        }
//        else{
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//}
