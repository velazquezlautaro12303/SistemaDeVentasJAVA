package com.example.demo.Repository;

import com.example.demo.Entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;


@RepositoryRestController(path = "user")
public interface RepoUser extends PagingAndSortingRepository<User,Integer> {
    // public User findUserByNameUserAndPassword(String nameUser, String password);
}
