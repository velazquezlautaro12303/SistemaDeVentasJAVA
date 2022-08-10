package com.example.demo.Repository;

import com.example.demo.Entity.Brand;
import com.example.demo.View.BrandView;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "/brand", excerptProjection = BrandView.class)
@CrossOrigin
public interface RepoBrand extends PagingAndSortingRepository<Brand, Integer> {
}
