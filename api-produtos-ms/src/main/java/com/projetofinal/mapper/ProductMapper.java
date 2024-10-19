package com.projetofinal.mapper;

import org.springframework.stereotype.Component;

import com.projetofinal.dto.ProductDTO;
import com.projetofinal.dto.ProductRequestDTO;
import com.projetofinal.model.Product;

@Component
public class ProductMapper {
    public ProductDTO toDTO(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getQuantity(), product.getPrice());
    }

    public Product toEntity(ProductRequestDTO productRequestDTO) {
        return new Product(null, productRequestDTO.getName(), productRequestDTO.getQuantity(), productRequestDTO.getPrice());
    }
}
