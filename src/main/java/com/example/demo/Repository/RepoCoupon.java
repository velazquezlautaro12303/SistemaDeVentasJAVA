package com.example.demo.Repository;

import com.example.demo.Entity.Coupon;
import com.example.demo.View.CouponView;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "/coupon", excerptProjection = CouponView.class)
@CrossOrigin
public interface RepoCoupon extends PagingAndSortingRepository<Coupon,Integer> {
}
