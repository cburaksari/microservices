package main.java.order.service.domain.model;

import java.time.LocalDateTime;
import java.util.Random;

import lombok.Data;

@Data
public class Order {
    private Long id;
    private String name;
    private OrderProduct orderProduct;
    private LocalDateTime expiryDate;

    public Order(String name, OrderProduct orderProduct, LocalDateTime expiryDate) {
        this.name = name;
        this.orderProduct = orderProduct;
        this.expiryDate = expiryDate;
        this.id = (long) (new Random().nextInt(100) + 1);
    }
}
