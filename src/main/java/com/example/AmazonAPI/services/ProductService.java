package com.example.AmazonAPI.services;

import com.example.AmazonAPI.models.Product;
import com.example.AmazonAPI.models.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getProducts()
    {
        return repository.findAll();
    }

    public void insertIntoProduct(Product product)
    {
        repository.insert(product);
    }


    public List<Product> getProductbyCategory(String category)
    {
        return repository.findByCategory(category);
    }

    public List<Product> getBestsellerProduct(Boolean bestseller)
    {
        return repository.findByBestseller(bestseller);
    }

    public Optional<Product> getAProduct(String id)
    {
        return repository.findById(id);
    }

    public void deleteAProduct(String id)
    {
        repository.deleteById(id);
    }

}
