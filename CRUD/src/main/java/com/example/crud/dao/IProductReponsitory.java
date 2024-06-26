package com.example.crud.dao;

import com.example.crud.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductReponsitory  extends CrudRepository<Product,Integer> {
}
