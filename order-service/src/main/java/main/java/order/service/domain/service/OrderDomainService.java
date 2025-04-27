package main.java.order.service.domain.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import main.java.order.service.domain.model.Order;
import main.java.order.service.domain.model.OrderProduct;

public class OrderDomainService {

    public Order generateOrderByProduct(OrderProduct orderProduct) {
        String orderName = generateOrderName(orderProduct.getName());
        LocalDateTime expiryDate = calculateExpiryDate();
        return new Order(orderName, orderProduct, expiryDate);
    }

    private String generateOrderName(String productName) {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return productName + "_" + date;
    }

    private LocalDateTime calculateExpiryDate() {
        return LocalDateTime.now().plusWeeks(2);
    }
}
