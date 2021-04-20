package com.example.AmazonAPI.controllers;

import com.example.AmazonAPI.CustomizedResponse;
import com.example.AmazonAPI.models.Product;
import com.example.AmazonAPI.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;


@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public ResponseEntity getProducts()
    {
        var customizedResponse = new CustomizedResponse("List of all products",service.getProducts());
        return new ResponseEntity(customizedResponse,HttpStatus.OK);
    }

    @PostMapping(value = "/category",consumes = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity getProductbyCategory(@RequestBody Product product)
    {
        var customizedResponse = new CustomizedResponse("Products by category", service.getProductbyCategory(product.getCategory()));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @GetMapping("/bestseller")
    public ResponseEntity getBestsellerProduct()
    {
        var customizedResponse = new CustomizedResponse("Bestseller Products", service.getBestsellerProduct(true));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }


    @GetMapping("/products/{id}")
    public ResponseEntity getAProduct(@PathVariable("id") String id)
    {

        var customizedResponse = new CustomizedResponse("Product with id :"+id, Collections.singletonList(service.getAProduct(id)));

        return new ResponseEntity(customizedResponse,HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteAProduct(@PathVariable("id") String id)
    {
        service.deleteAProduct(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/products/add",consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity addProduct(@RequestBody Product product)
    {

        service.insertIntoProduct(product);

        return new ResponseEntity(product,HttpStatus.OK);

    }
}
