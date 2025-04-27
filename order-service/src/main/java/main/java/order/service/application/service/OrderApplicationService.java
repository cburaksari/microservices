package main.java.order.service.application.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import main.java.order.service.application.port.in.CreateOrderPort;
import main.java.order.service.application.port.in.GetAllOrdersPort;
import main.java.order.service.application.port.out.OrderRepositoryPort;
import main.java.order.service.domain.model.Order;
import main.java.order.service.domain.model.OrderProduct;
import main.java.order.service.domain.service.OrderDomainService;

@RequiredArgsConstructor
public class OrderApplicationService implements CreateOrderPort, GetAllOrdersPort {

    private final OrderDomainService orderService;
    private final OrderRepositoryPort orderRepositoryPort;

    @Override
    public void createOrder(OrderProduct orderProduct) {
        Order order = orderService.generateOrderByProduct(orderProduct);
        orderRepositoryPort.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepositoryPort.getAllOrders();
    }

}
