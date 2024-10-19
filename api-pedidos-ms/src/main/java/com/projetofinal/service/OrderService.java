package com.projetofinal.service;

import org.springframework.stereotype.Service;

import com.projetofinal.dto.OrderDTO;
import com.projetofinal.dto.OrderRequestDTO;
import com.projetofinal.external.ProductClient;
import com.projetofinal.mapper.OrderMapper;
import com.projetofinal.model.Order;
import com.projetofinal.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;
    private final OrderMapper orderMapper;

    public OrderDTO createOrder(OrderRequestDTO orderRequestDTO) {
        Long productId = orderRequestDTO.getProductId();
        int quantity = orderRequestDTO.getQuantity();

        if (productClient.checkProductAvailability(productId, quantity)) {
            productClient.updateProductQuantity(productId, quantity);
            Order order = orderMapper.toEntity(orderRequestDTO);
            order.setStatus("Pendente");
            Order savedOrder = orderRepository.save(order);
            return orderMapper.toDTO(savedOrder);
        } else {
            throw new RuntimeException("Produto indisponível.");
        }
    }
}
