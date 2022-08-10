package com.example.demo.Repository;

import com.example.demo.Entity.Category;
import com.example.demo.View.CategoryView;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "category", excerptProjection = CategoryView.class)
@CrossOrigin
public interface RepoCategory extends PagingAndSortingRepository<Category, Integer> {
}
