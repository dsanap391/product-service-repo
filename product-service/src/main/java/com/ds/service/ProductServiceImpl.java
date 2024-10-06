package com.ds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.exception.ProductServiceException;
import com.ds.model.Product;
import com.ds.payload.request.ProductRequest;
import com.ds.payload.response.ProductResponse;
import com.ds.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public long addProduct(ProductRequest productRequest) {
		Product product = new Product();

		product.setProductName(productRequest.getName());
		product.setQuantity(productRequest.getQuantity());
		product.setPrice(productRequest.getPrice());

		Product addProduct = productRepository.save(product);
		return addProduct.getProductId();
	}

	@Override
	public ProductResponse getProductById(long productId) {

		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ProductServiceException("Product with given Id not found", "PRODUCT_NOT_FOUND"));

		ProductResponse productResponse = new ProductResponse();

		return productResponse;
	}

	@Override
	public void reduceQuantity(long productId, long quantity) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ProductServiceException("Product with given Id not found", "PRODUCT_NOT_FOUND"));

		if (product.getQuantity() < quantity) {
			throw new ProductServiceException("Product does not have sufficient Quantity", "INSUFFICIENT_QUANTITY");
		}

		product.setQuantity(product.getQuantity() - quantity);
		productRepository.save(product);
	}

	@Override
	public void deleteProductById(long productId) {
		 if (!productRepository.existsById(productId)) {
	            throw new ProductServiceException(
	                    "Product with given with Id: " + productId + " not found:",
	                    "PRODUCT_NOT_FOUND");
	        }
	        productRepository.deleteById(productId);
	}
}
