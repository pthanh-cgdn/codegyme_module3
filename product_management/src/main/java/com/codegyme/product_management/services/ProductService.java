package com.codegyme.product_management.services;

import com.codegyme.product_management.models.Product;
import com.codegyme.product_management.repositories.ProductRepository;

import java.util.List;

public class ProductService {
    private ProductRepository productRepository = new ProductRepository();
    public boolean addProduct(Product product) {
        return productRepository.add(product);
    }

    public Product findProductById(int productId) {
        return productRepository.findProductById(productId);
    }

    public void remove(Product product) {
        productRepository.remove(product);
    }

    public boolean editProduct(int id, Product product) {
        return productRepository.editProduct(id,product);
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public List<Product> search(String searchContent) {
        return productRepository.search(searchContent);
    }
}
