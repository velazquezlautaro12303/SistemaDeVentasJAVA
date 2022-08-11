package com.example.demo.Repository;

import com.example.demo.Entity.Product;
import com.example.demo.View.ProductView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "product", excerptProjection = ProductView.class)
@CrossOrigin
public interface RepoProduct extends PagingAndSortingRepository<Product,Integer> {

    public Page<Product> findAllByStockGreaterThan(Pageable page, Integer stock);
    public Page<Product> findAllByNameProductContainingAndStockGreaterThan(String search, Pageable page, Integer stock);
    public Page<Product> findAllByPriceBetweenAndStockGreaterThan(Double minPrice, Double maxPrice, Pageable page, Integer stock);
    public Page<Product> findAllByBrand_NameBrandAndStockGreaterThan(String nameBrand, Pageable page, Integer stock);
    public Page<Product> findAllByCategory_NameCategoryAndStockGreaterThan(String nameCategory, Pageable page, Integer stock);

    public Page<Product> findAllByBrand_NameBrandAndPriceBetweenAndStockGreaterThan(String nameBrand, Double minPrice, Double maxPrice, Pageable page, Integer stock);

    public Page<Product> findAllByCategory_NameCategoryAndPriceBetweenAndStockGreaterThan(String nameCategory, Double minPrice, Double maxPrice, Pageable page, Integer stock);

    public Page<Product> findAllByBrand_NameBrandAndCategory_NameCategoryAndStockGreaterThan(String nameBrand,String nameCategory, Pageable page, Integer stock);
    public Page<Product> findAllByBrand_NameBrandAndCategory_NameCategoryAndPriceBetweenAndStockGreaterThan(String nameBrand,String nameCategory, Double minPrice, Double maxPrice, Pageable page, Integer stock);

    public Page<Product> findAllByNameProductContainingAndBrand_NameBrandAndStockGreaterThan(String search, String nameBrand, Pageable page, Integer stock);
    public Page<Product> findAllByNameProductContainingAndBrand_NameBrandAndPriceBetweenAndStockGreaterThan(String search, String nameBrand, Double minPrice, Double maxPrice, Pageable page, Integer stock);

    public Page<Product> findAllByNameProductContainingAndCategory_NameCategoryAndStockGreaterThan(String search, String nameCategory, Pageable page, Integer stock);
    public Page<Product> findAllByNameProductContainingAndCategory_NameCategoryAndPriceBetweenAndStockGreaterThan(String search, String nameCategory, Double minPrice, Double maxPrice, Pageable page, Integer stock);

    public Page<Product> findAllByNameProductContainingAndCategory_NameCategoryAndBrand_NameBrandAndStockGreaterThan(String search, String nameCategory, String nameBrand, Pageable page, Integer stock);
    public Page<Product> findAllByNameProductContainingAndCategory_NameCategoryAndBrand_NameBrandAndPriceBetweenAndStockGreaterThan(String search, String nameCategory, String nameBrand, Double minPrice, Double maxPrice, Pageable page, Integer stock);

    @Override
    @RestResource(exported = false)
    public void deleteById(Integer id);
}
