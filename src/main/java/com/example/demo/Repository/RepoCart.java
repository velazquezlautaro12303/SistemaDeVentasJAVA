package com.example.demo.Repository;

import com.example.demo.Entity.Cart;
import com.example.demo.View.CartView;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "/cart", excerptProjection = CartView.class)
@CrossOrigin
public interface RepoCart extends PagingAndSortingRepository<Cart, Integer> {
}
