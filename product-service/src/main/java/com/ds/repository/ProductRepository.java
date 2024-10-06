package com.ds.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ds.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
