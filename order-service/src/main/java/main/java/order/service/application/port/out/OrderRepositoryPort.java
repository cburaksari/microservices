package main.java.order.service.application.port.out;

import java.util.List;
import main.java.order.service.domain.model.Order;

public interface OrderRepositoryPort {
    Order save(Order order);

    List<Order> getAllOrders();
}
