package com.example.demo.Controller;

import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RepositoryRestController
@CrossOrigin
public class ControllerCart {

    @Autowired
    private RepoCart repoCart;
    @Autowired
    private RepoItemCart repoItemCart;
    @Autowired
    private RepoUser repoUser;
    @Autowired
    private RepoMethodBuy repoMethodBuy;
    @Autowired
    private RepoProduct repoProduct;
    @Autowired
    private RepoCoupon repoCoupon;
    private double total = 0;

    @CrossOrigin
    @PostMapping("cart")
    public @ResponseBody ResponseEntity<Cart> createCart(@RequestBody Cart cart){
        if ( this.repoUser.existsById(cart.getUserId()) ) {
            User user = this.repoUser.findById(cart.getUserId()).get();
            cart.setUser(user);
        }
        if ( this.repoMethodBuy.existsById(cart.getMethodBuyId()) ) {
            MethodBuy methodBuy = this.repoMethodBuy.findById(cart.getMethodBuyId()).get();
            cart.setMethodBuy(methodBuy);
        }

        if ( this.repoCoupon.existsById(cart.getCouponId()) ) {
            cart.setCoupon(repoCoupon.findById(cart.getCouponId()).get());
        }

        this.repoCart.save(cart);

        this.total = 0;

        cart.getItemCarts().stream().forEach(itemCart -> {
            itemCart.setCart(cart);
            itemCart.setProduct(repoProduct.findById(itemCart.getProductId()).get());
            repoItemCart.save(itemCart);
            if (itemCart.getProduct().getStock() > 0){
                this.total = this.total + itemCart.getProduct().getPrice() * itemCart.getCant();
                Product p = itemCart.getProduct();
                p.setStock(p.getStock() - itemCart.getCant());
                repoProduct.save(p);
            }
        });

        this.total = this.total - cart.getCoupon().getDiscount();

        cart.setTotal((int) this.total);
        this.repoCart.save(cart);

        return ResponseEntity.ok().build();
    }

}
