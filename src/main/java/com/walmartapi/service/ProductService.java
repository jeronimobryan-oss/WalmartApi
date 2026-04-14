package com.walmartapi.service;

import com.walmartapi.entity.ProductEntity;
import com.walmartapi.exception.NotFound;
import com.walmartapi.mapper.CustomObjectMapper;
import com.walmartapi.model.Product;
import com.walmartapi.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CustomObjectMapper<ProductEntity, Product> productMapper;

    public ProductService(ProductRepository productRepository, CustomObjectMapper<ProductEntity, Product> productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Product saveProduct(Product product) {
        ProductEntity newproduct = productMapper.mapTopEntity(product);
        ProductEntity savedEntity = productRepository.save(newproduct);
        return productMapper.mapToDto(savedEntity);
    }

    public Product getProductById(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if (product.isEmpty())
            throw new NotFound("Product not found");
        return productMapper.mapToDto(product.get());
    }

    public Product updateProduct(Long id, Product product) {
        //Validamos si existe en la BD
        if (!productRepository.existsById(id)) {
            throw new NotFound("Product not found");
        }

        //Mapeamos
        ProductEntity entityToUpdate = productMapper.mapTopEntity(product);

        //Seteamos el ID del path para que JPA haga UPDATE
        entityToUpdate.setId(id);
        // Guardamos la entidad y mapeamos de vuelta
        ProductEntity savedEntity = productRepository.save(entityToUpdate);
        return productMapper.mapToDto(savedEntity);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new NotFound("Product not found"+id);
        }
        productRepository.deleteById(id);
    }


}