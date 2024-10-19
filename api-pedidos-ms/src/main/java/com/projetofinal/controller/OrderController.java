package com.projetofinal.controller;

import com.projetofinal.dto.OrderDTO;
import com.projetofinal.dto.OrderRequestDTO;
import com.projetofinal.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        return orderService.createOrder(orderRequestDTO);
    }
}
