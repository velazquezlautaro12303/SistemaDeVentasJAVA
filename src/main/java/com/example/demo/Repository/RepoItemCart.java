package com.example.demo.Repository;

import com.example.demo.Entity.ItemCart;
import com.example.demo.View.ItemCartView;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "itemCart", excerptProjection = ItemCartView.class)
@CrossOrigin
public interface RepoItemCart extends PagingAndSortingRepository<ItemCart, Integer> {
}
