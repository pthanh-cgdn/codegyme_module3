package com.codegyme.product_management.repositories;

import com.codegyme.product_management.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    List<Product> products = new ArrayList<>();
    public boolean add(Product product) {
        if (!products.isEmpty()){
            product.setId(products.get(products.size() - 1).getId());
        } else {
            product.setId(1);
        }
        products.add(product);
        return true;
    }

    public Product findProductById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    public void remove(Product product) {
        products.remove(product);
    }

    public boolean editProduct(int id, Product product) {
        for (Product product1 : products) {
            if (product1.getId() == id) {
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                product1.setCategoryName(product.getCategoryName());
                product1.setManufacture(product.getManufacture());
                return true;
            }
        }
        return false;
    }

    public List<Product> getAll() {
        return this.products;
    }
}
