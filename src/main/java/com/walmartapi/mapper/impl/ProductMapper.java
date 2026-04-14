package com.walmartapi.mapper.impl;

import com.walmartapi.entity.ProductEntity;
import com.walmartapi.mapper.CustomObjectMapper;
import com.walmartapi.model.Product;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements CustomObjectMapper<ProductEntity, Product> {
    @Override
    public ProductEntity mapTopEntity(Product dto) {
        //Producto a entity
        //Esto es un mappeo, es tomar lo valores y pasarlo a otros
        ProductEntity productEntity = new ProductEntity();
        //No es responabilidad del servicio hacer un ID, eso es parte de la base de datos, ademas que es un elemento nuevo
        productEntity.setDescription(dto.getDescription());
        productEntity.setName(dto.getName());
        productEntity.setPrice(dto.getPrice());
        return null;
    }

    @Override
    public Product mapToDto(ProductEntity entity) {
        Product savedProduct = new Product();
        savedProduct.setName(entity.getName());
        savedProduct.setDescription(entity.getDescription());
        savedProduct.setPrice(entity.getPrice());
        savedProduct.setId(entity.getId());
        return null;
    }
}
