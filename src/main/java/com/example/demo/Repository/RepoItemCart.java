package com.example.demo.Repository;

import com.example.demo.Entity.ItemCart;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "itemCart")
public interface RepoItemCart extends PagingAndSortingRepository<ItemCart, Integer> {
}
