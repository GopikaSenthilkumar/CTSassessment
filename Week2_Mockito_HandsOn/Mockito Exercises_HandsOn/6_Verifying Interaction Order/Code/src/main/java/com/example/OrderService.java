package com.example;
public class OrderService {
    private final InventoryService inventoryService;
    public OrderService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    public void processOrder(String itemId) {
        inventoryService.reserveItem(itemId);
        inventoryService.packItem(itemId);
        inventoryService.shipItem(itemId);
    }
}
