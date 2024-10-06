package com.ds.service;

import com.ds.payload.request.ProductRequest;
import com.ds.payload.response.ProductResponse;

public interface ProductService {

	long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);

    void reduceQuantity(long productId, long quantity);

    public void deleteProductById(long productId);
}
