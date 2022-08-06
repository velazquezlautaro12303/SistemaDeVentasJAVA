package com.example.demo.Repository;

import com.example.demo.Entity.MethodBuy;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface RepoMethodBuy extends PagingAndSortingRepository<MethodBuy,Integer> {
}
