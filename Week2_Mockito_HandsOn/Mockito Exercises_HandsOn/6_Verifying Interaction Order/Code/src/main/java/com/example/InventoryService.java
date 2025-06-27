package com.example;
public interface InventoryService {
    void reserveItem(String itemId);
    void packItem(String itemId);
    void shipItem(String itemId);
}
