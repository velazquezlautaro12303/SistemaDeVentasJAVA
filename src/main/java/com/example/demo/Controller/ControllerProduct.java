package com.example.demo.Controller;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.RepoBrand;
import com.example.demo.Repository.RepoCategory;
import com.example.demo.Repository.RepoProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@CrossOrigin
public class ControllerProduct {

    @Autowired
    private RepoProduct repoProduct;
    @Autowired
    private RepoBrand repoBrand;
    @Autowired
    private RepoCategory repoCategory;

    @GetMapping("product")
    public Page<Product> getUsers(
            Pageable pageable,
            @RequestParam(value = "category",required = false) String category,
            @RequestParam(value = "brand",required = false) String brand,
            @RequestParam(value = "nameProduct",required = false) String nameProduct,
            @RequestParam(value = "minPrice", required = false) Double minPrice,
            @RequestParam(value = "maxPrice", required = false) Double maxPrice
    ){
        Page<Product> response = repoProduct.findAll(pageable);
        if (nameProduct != null && brand == null && category == null && minPrice == null && maxPrice == null) {
            response = repoProduct.findAllByNameProductContaining(nameProduct,pageable);
        } else if (nameProduct == null && brand != null && category == null && minPrice == null && maxPrice == null) {
            response = repoProduct.findAllByBrand_NameBrand(brand, pageable);
        } else if (nameProduct == null && brand == null && category != null && minPrice == null && maxPrice == null) {
            response = repoProduct.findAllByCategory_NameCategory(category, pageable);
        } else if(nameProduct == null && brand != null & category != null && minPrice == null && maxPrice == null) {
            response = repoProduct.findAllByBrand_NameBrandAndCategory_NameCategory(brand, category, pageable);
        } else if(nameProduct != null && brand != null & category == null && minPrice == null && maxPrice == null) {
            response = repoProduct.findAllByNameProductContainingAndBrand_NameBrand(nameProduct, brand, pageable);
        } else if(nameProduct != null && brand != null & category != null && minPrice == null && maxPrice == null) {
            response = repoProduct.findAllByNameProductContainingAndCategory_NameCategoryAndBrand_NameBrand(nameProduct,category,brand, pageable);
        } else if(nameProduct != null && brand == null & category != null && minPrice == null && maxPrice == null) {
            response = repoProduct.findAllByNameProductContainingAndCategory_NameCategory(nameProduct, category, pageable);
        } else if(nameProduct == null && brand == null & category == null && minPrice != null && maxPrice != null) {
            response = repoProduct.findAllByPriceBetween(minPrice, maxPrice, pageable);
        } else if(nameProduct == null && brand != null & category == null && minPrice != null && maxPrice != null) {
            response = repoProduct.findAllByBrand_NameBrandAndPriceBetween(brand, minPrice, maxPrice, pageable);
        } else if(nameProduct == null && brand != null & category != null && minPrice != null && maxPrice != null) {
            response = repoProduct.findAllByBrand_NameBrandAndCategory_NameCategoryAndPriceBetween(brand, category, minPrice, maxPrice, pageable);
        } else if(nameProduct == null && brand == null & category != null && minPrice != null && maxPrice != null) {
            response = repoProduct.findAllByCategory_NameCategoryAndPriceBetween(category, minPrice, maxPrice, pageable);
        } else if(nameProduct != null && brand != null & category == null && minPrice != null && maxPrice != null) {
            response = repoProduct.findAllByNameProductContainingAndBrand_NameBrandAndPriceBetween(nameProduct, brand, minPrice, maxPrice, pageable);
        } else if(nameProduct != null && brand == null & category != null && minPrice != null && maxPrice != null) {
            response = repoProduct.findAllByNameProductContainingAndCategory_NameCategoryAndPriceBetween(nameProduct, category, minPrice, maxPrice, pageable);
        } else if(nameProduct != null && brand != null & category != null && minPrice != null && maxPrice != null) {
            response = repoProduct.findAllByNameProductContainingAndCategory_NameCategoryAndBrand_NameBrandAndPriceBetween(nameProduct, category, brand, minPrice, maxPrice, pageable);
        }
        return response;
    }

    @DeleteMapping(path = "product/{id}")
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

    @PutMapping(path = "product/{id}")
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

    @PostMapping(path = "product")
    public @ResponseBody ResponseEntity<Product> updateProduct(@RequestBody Product p){
        p.setBrand(repoBrand.findById(p.getBrandId()).get());
        p.setCategory(repoCategory.findById(p.getCategoryId()).get());
        this.repoProduct.save(p);
        return ResponseEntity.ok(p);
    }


}