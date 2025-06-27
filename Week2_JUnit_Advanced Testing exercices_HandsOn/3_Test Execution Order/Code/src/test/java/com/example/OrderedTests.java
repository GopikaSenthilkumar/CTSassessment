package com.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {
    @Test
    @Order(2)
    void secondTest() {
        System.out.println("Second test executed");
    }
    @Test
    @Order(1)
    void firstTest() {
        System.out.println("First test executed");
    }
    @Test
    @Order(3)
    void thirdTest() {
        System.out.println("Third test executed");
    }
}