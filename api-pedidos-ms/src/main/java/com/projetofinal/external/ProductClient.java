package com.projetofinal.external;

@FeignClient(name = "product-service")
public interface ProductClient {

    @PostMapping("/api/products/check-availability")
    boolean checkProductAvailability(@RequestParam Long productId, @RequestParam int quantity);

    @PostMapping("/api/products/update-quantity")
    void updateProductQuantity(@RequestParam Long productId, @RequestParam int quantity);
}
