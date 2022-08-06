package com.example.demo.Repository;

import com.example.demo.Entity.Coupon;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "coupon")
public interface RepoCoupon extends PagingAndSortingRepository<Coupon,Integer> {
}
