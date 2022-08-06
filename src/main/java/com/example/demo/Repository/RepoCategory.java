package com.example.demo.Repository;

import com.example.demo.Entity.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface RepoCategory extends PagingAndSortingRepository<Category, Integer> {
}
