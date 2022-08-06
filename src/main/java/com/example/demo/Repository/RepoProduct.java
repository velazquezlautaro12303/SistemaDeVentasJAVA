package com.example.demo.Repository;

import com.example.demo.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "product")
//@CrossOrigin
public interface RepoProduct extends PagingAndSortingRepository<Product,Integer> {

    public Page<Product> findAllByNameProductContaining(String search, Pageable page);
    public Page<Product> findAllByPriceBetween(Double minPrice, Double maxPrice, Pageable page);
    public Page<Product> findAllByBrand_NameBrand(String nameBrand, Pageable page);
    public Page<Product> findAllByCategory_NameCategory(String nameCategory, Pageable page);

    public Page<Product> findAllByBrand_NameBrandAndPriceBetween(String nameBrand, Double minPrice, Double maxPrice, Pageable page);

    public Page<Product> findAllByCategory_NameCategoryAndPriceBetween(String nameCategory, Double minPrice, Double maxPrice, Pageable page);

    public Page<Product> findAllByBrand_NameBrandAndCategory_NameCategory(String nameBrand,String nameCategory, Pageable page);
    public Page<Product> findAllByBrand_NameBrandAndCategory_NameCategoryAndPriceBetween(String nameBrand,String nameCategory, Double minPrice, Double maxPrice, Pageable page);

    public Page<Product> findAllByNameProductContainingAndBrand_NameBrand(String search, String nameBrand, Pageable page);
    public Page<Product> findAllByNameProductContainingAndBrand_NameBrandAndPriceBetween(String search, String nameBrand, Double minPrice, Double maxPrice, Pageable page);

    public Page<Product> findAllByNameProductContainingAndCategory_NameCategory(String search, String nameCategory, Pageable page);
    public Page<Product> findAllByNameProductContainingAndCategory_NameCategoryAndPriceBetween(String search, String nameCategory, Double minPrice, Double maxPrice, Pageable page);

    public Page<Product> findAllByNameProductContainingAndCategory_NameCategoryAndBrand_NameBrand(String search, String nameCategory, String nameBrand, Pageable page);
    public Page<Product> findAllByNameProductContainingAndCategory_NameCategoryAndBrand_NameBrandAndPriceBetween(String search, String nameCategory, String nameBrand, Double minPrice, Double maxPrice, Pageable page);

    @Override
    @RestResource(exported = false)
    public void deleteById(Integer id);
}
