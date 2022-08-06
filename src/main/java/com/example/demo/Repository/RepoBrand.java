package com.example.demo.Repository;

import com.example.demo.Entity.Brand;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface RepoBrand extends PagingAndSortingRepository<Brand, Integer> {
}
