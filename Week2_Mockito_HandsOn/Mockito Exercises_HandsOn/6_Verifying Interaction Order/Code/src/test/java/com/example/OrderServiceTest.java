package com.example;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.mockito.InOrder;
public class OrderServiceTest {
    @Test
    public void testMethodCallOrder() {
        InventoryService mockInventory = mock(InventoryService.class);
        OrderService orderService = new OrderService(mockInventory);
        orderService.processOrder("ITEM001");
        InOrder inOrder = inOrder(mockInventory);
        inOrder.verify(mockInventory).reserveItem("ITEM001");
        inOrder.verify(mockInventory).packItem("ITEM001");
        inOrder.verify(mockInventory).shipItem("ITEM001");
    }
}
