package com.enoca.demo.service;

import com.enoca.demo.model.Product;
import com.enoca.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProduct(){
        return productRepository.findAll();
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Product product){
        Product p = productRepository.findById(product.getId()).orElseThrow();
        product.setLastPrice(p.getPrice());
        return productRepository.save(product);
    }

    public void deleteProduct(int productId){
        productRepository.deleteById(productId);
    }

}
