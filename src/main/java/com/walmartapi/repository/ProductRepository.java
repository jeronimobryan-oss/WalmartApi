package com.walmartapi.repository;

import com.walmartapi.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                                             //Lo que esta dentro de las llaver <> es un tipo de dato generico
public interface ProductRepository extends JpaRepository<ProductEntity,Long > {
        //El interface a diferencia de una clase no tiene una parte logica por que despues debera de ser declarada en una clase e implementada en esta

}
