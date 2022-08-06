package com.example.demo.Repository;

import com.example.demo.Entity.Cart;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "cart")
public interface RepoCart extends PagingAndSortingRepository<Cart, Integer> {
}
