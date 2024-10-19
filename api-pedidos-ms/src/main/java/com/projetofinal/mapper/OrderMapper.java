package com.projetofinal.mapper;

import org.springframework.stereotype.Component;

import com.projetofinal.dto.OrderDTO;
import com.projetofinal.dto.OrderRequestDTO;
import com.projetofinal.model.Order;

@Component
public class OrderMapper {

    public OrderDTO toDTO(Order order) {
        return new OrderDTO(order.getId(), order.getProductId(), order.getQuantity(), order.getStatus());
    }

    public Order toEntity(OrderRequestDTO orderRequestDTO) {
        Order order = new Order();
        order.setProductId(orderRequestDTO.getProductId());
        order.setQuantity(orderRequestDTO.getQuantity());
        return order;
    }
}

