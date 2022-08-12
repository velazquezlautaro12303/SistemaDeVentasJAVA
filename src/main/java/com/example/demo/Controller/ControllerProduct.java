package com.example.demo.Controller;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.RepoBrand;
import com.example.demo.Repository.RepoCategory;
import com.example.demo.Repository.RepoProduct;
import com.example.demo.Services.ServiceSpring;
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
    @Autowired
    private ServiceSpring serviceSpring;

    @GetMapping("product")
    public Page<Product> getUsers(
            Pageable pageable,
            @RequestParam(value = "category",required = false) String category,
            @RequestParam(value = "brand",required = false) String brand,
            @RequestParam(value = "nameProduct",required = false) String nameProduct,
            @RequestParam(value = "minPrice", required = false) Double minPrice,
            @RequestParam(value = "maxPrice", required = false) Double maxPrice
    ){
        Page<Product> response = repoProduct.findAllByStockGreaterThan(pageable,0);
        if (nameProduct != null && brand == null && category == null && minPrice == null && maxPrice == null) {
            response = repoProduct.findAllByNameProductContainingAndStockGreaterThan(nameProduct,pageable,0);
        } else if (nameProduct == null && brand != null && category == null && minPrice == null && maxPrice == null) {
            response = repoProduct.findAllByBrand_NameBrandAndStockGreaterThan(brand, pageable,0);
        } else if (nameProduct == null && brand == null && category != null && minPrice == null && maxPrice == null) {
            response = repoProduct.findAllByCategory_NameCategoryAndStockGreaterThan(category, pageable,0);
        } else if(nameProduct == null && brand != null & category != null && minPrice == null && maxPrice == null) {
            response = repoProduct.findAllByBrand_NameBrandAndCategory_NameCategoryAndStockGreaterThan(brand, category, pageable,0);
        } else if(nameProduct != null && brand != null & category == null && minPrice == null && maxPrice == null) {
            response = repoProduct.findAllByNameProductContainingAndBrand_NameBrandAndStockGreaterThan(nameProduct, brand, pageable,0);
        } else if(nameProduct != null && brand != null & category != null && minPrice == null && maxPrice == null) {
            response = repoProduct.findAllByNameProductContainingAndCategory_NameCategoryAndBrand_NameBrandAndStockGreaterThan(nameProduct,category,brand, pageable,0);
        } else if(nameProduct != null && brand == null & category != null && minPrice == null && maxPrice == null) {
            response = repoProduct.findAllByNameProductContainingAndCategory_NameCategoryAndStockGreaterThan(nameProduct, category, pageable,0);
        } else if(nameProduct == null && brand == null & category == null && minPrice != null && maxPrice != null) {
            response = repoProduct.findAllByPriceBetweenAndStockGreaterThan(minPrice, maxPrice, pageable,0);
        } else if(nameProduct == null && brand != null & category == null && minPrice != null && maxPrice != null) {
            response = repoProduct.findAllByBrand_NameBrandAndPriceBetweenAndStockGreaterThan(brand, minPrice, maxPrice, pageable,0);
        } else if(nameProduct == null && brand != null & category != null && minPrice != null && maxPrice != null) {
            response = repoProduct.findAllByBrand_NameBrandAndCategory_NameCategoryAndPriceBetweenAndStockGreaterThan(brand, category, minPrice, maxPrice, pageable,0);
        } else if(nameProduct == null && brand == null & category != null && minPrice != null && maxPrice != null) {
            response = repoProduct.findAllByCategory_NameCategoryAndPriceBetweenAndStockGreaterThan(category, minPrice, maxPrice, pageable,0);
        } else if(nameProduct != null && brand != null & category == null && minPrice != null && maxPrice != null) {
            response = repoProduct.findAllByNameProductContainingAndBrand_NameBrandAndPriceBetweenAndStockGreaterThan(nameProduct, brand, minPrice, maxPrice, pageable,0);
        } else if(nameProduct != null && brand == null & category != null && minPrice != null && maxPrice != null) {
            response = repoProduct.findAllByNameProductContainingAndCategory_NameCategoryAndPriceBetweenAndStockGreaterThan(nameProduct, category, minPrice, maxPrice, pageable,0);
        } else if(nameProduct != null && brand != null & category != null && minPrice != null && maxPrice != null) {
            response = repoProduct.findAllByNameProductContainingAndCategory_NameCategoryAndBrand_NameBrandAndPriceBetweenAndStockGreaterThan(nameProduct, category, brand, minPrice, maxPrice, pageable,0);
        }
        response.get().forEach(product -> product.setPriceAPI(this.serviceSpring.getCompra() * product.getPrice()));
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

    @PostMapping(path = "product/{id}")
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
    public @ResponseBody ResponseEntity<Product> createProduct(@RequestBody Product p){
        p.setBrand(repoBrand.findById(p.getBrandId()).get());
        p.setCategory(repoCategory.findById(p.getCategoryId()).get());
        this.repoProduct.save(p);
        return ResponseEntity.ok(p);
    }

    @GetMapping(path = "product/{id}")
    Product getProduct(@PathVariable("id") Integer id){
        return repoProduct.findById(id).get();
    }
}