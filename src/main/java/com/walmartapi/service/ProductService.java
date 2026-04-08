package com.walmartapi.service;

import com.walmartapi.entity.ProductEntity;
import com.walmartapi.model.Product;
import com.walmartapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        //Esto es un mappeo, es tomar lo valores y pasarlo a otros
        ProductEntity productEntity = new ProductEntity();
        //No es responabilidad del servicio hacer un ID, eso es parte de la base de datos, ademas que es un elemento nuevo
        productEntity.setDescription(product.getDescription());
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());

        ProductEntity savedEntity = productRepository.save(productEntity);
        product.setName(savedEntity.getName());
        product.setDescription(savedEntity.getDescription());
        product.setPrice(savedEntity.getPrice());
        product.setId(savedEntity.getId());
        return product;
    }

}
