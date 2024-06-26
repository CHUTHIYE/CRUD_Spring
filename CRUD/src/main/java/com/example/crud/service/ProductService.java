package com.example.crud.service;


import com.example.crud.dao.IProductReponsitory;
import com.example.crud.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{
    private final IProductReponsitory productReponsitory;

    @Autowired
    public ProductService(IProductReponsitory productReponsitory) {
        this.productReponsitory = productReponsitory;
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productReponsitory.findAll();
    }

    @Override
    public Optional<Product> getProductById(int id) {
        return productReponsitory.findById(id);
    }

    @Override
    @Transactional
    public void addProduct(Product product) {
        productReponsitory.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        Optional<Product> existedProduct = productReponsitory.findById(product.p_id);
        if (existedProduct.isPresent()) {
            Product newProduct = existedProduct.get();
            newProduct.setP_id(product.getP_id());
            newProduct.setP_name(product.getP_name());
            newProduct.setDescription(product.getDescription());
            newProduct.setQuantity(product.getQuantity());
            productReponsitory.save(newProduct);
        } else {
            product.setP_id(product.p_id);
            productReponsitory.save(product);
        }
    }

    @Override
    public void deleteProduct(int id) {
        productReponsitory.deleteById(id);
    }
}
