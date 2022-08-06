package com.example.demo.Controller;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.RepoBrand;
import com.example.demo.Repository.RepoCategory;
import com.example.demo.Repository.RepoProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RepositoryRestController
@CrossOrigin
public class ControllerProduct {

    @Autowired
    private RepoProduct repoProduct;
    @Autowired
    private RepoBrand repoBrand;
    @Autowired
    private RepoCategory repoCategory;

    @DeleteMapping(path = "/product/{id}")
    public @ResponseBody ResponseEntity<Product> deleteProduct(@PathVariable("id") Integer id){
        Optional<Product> product = repoProduct.findById(id);
        if (product.isPresent()){
            product.get().setStock(0);
            this.repoProduct.save(product.get());
            return ResponseEntity.ok(product.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/product/{id}")
    public @ResponseBody ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @RequestBody Product p){
        Optional<Product> product = repoProduct.findById(id);
        if (product.isPresent()){
            Product p2 = product.get();
            p2.setNameProduct(p.getNameProduct());
            p2.setStock(p.getStock());
            p2.setPrice(p.getPrice());
            p2.setBrand(repoBrand.findById(p.getBrandId()).get());
            p2.setCategory(repoCategory.findById(p.getCategoryId()).get());
            this.repoProduct.save(p2);
            return ResponseEntity.ok(p2);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "/product")
    public @ResponseBody ResponseEntity<Product> updateProduct(@RequestBody Product p){
        p.setBrand(repoBrand.findById(p.getBrandId()).get());
        p.setCategory(repoCategory.findById(p.getCategoryId()).get());
        this.repoProduct.save(p);
        return ResponseEntity.ok(p);
    }


}