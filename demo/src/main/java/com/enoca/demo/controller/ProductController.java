package com.enoca.demo.controller;

import com.enoca.demo.model.Product;
import com.enoca.demo.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(
            summary = "getProduct Method",
            description = "Ürünleri listelemeye yardımcı olur."
    )
    @GetMapping("getProduct")
    public List<Product> getProduct(){
        return productService.getProduct();
    }

    @Operation(
            summary = "createProduct Method",
            description = "Ürün kaydını yapmaya yardımcı olur."
    )
    @PostMapping("createProduct")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @Operation(
            summary = "updateProduct Method",
            description = "Ürün bilgileri güncellemeye yardımcı olur."
    )
    @PutMapping("updateProduct")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @Operation(
            summary = "deleteProduct Method",
            description = "Belirli bir ürünü silmeye yardımcı olur."
    )
    @DeleteMapping("deleteProduct/{productId}")
    public void deleteProduct(@PathVariable int productId){
        productService.deleteProduct(productId);
    }

}
