package main.java.order.service.application.port.in;

import java.util.List;

import main.java.order.service.domain.model.Order;

public interface GetAllOrdersPort {
    List<Order> getAllOrders();
}
