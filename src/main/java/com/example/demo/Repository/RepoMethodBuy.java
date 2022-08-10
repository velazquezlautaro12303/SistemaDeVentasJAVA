package com.example.demo.Repository;

import com.example.demo.Entity.MethodBuy;
import com.example.demo.View.MethodBuyView;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "/methodBuy", excerptProjection = MethodBuyView.class)
@CrossOrigin
public interface RepoMethodBuy extends PagingAndSortingRepository<MethodBuy,Integer> {
}
