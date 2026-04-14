package com.walmartapi.mapper;

public interface CustomObjectMapper <E, D>{

    E mapTopEntity(D dto);
    D mapToDto(E entity);

}
