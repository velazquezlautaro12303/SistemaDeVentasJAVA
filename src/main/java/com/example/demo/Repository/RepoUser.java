package com.example.demo.Repository;

import com.example.demo.Entity.User;
import com.example.demo.View.UserView;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(path = "user", excerptProjection = UserView.class)
@CrossOrigin
public interface RepoUser extends PagingAndSortingRepository<User,Integer> {
    public User getUserByNameUserAndPasswordAndAvailableTrue(String nameUser, String password);
}
