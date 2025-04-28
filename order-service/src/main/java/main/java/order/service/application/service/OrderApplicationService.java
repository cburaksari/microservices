package main.java.order.service.application.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.java.order.service.application.port.in.CreateOrderPort;
import main.java.order.service.application.port.in.GetAllOrdersPort;
import main.java.order.service.application.port.in.GetProductPort;
import main.java.order.service.application.port.out.OrderRepositoryPort;
import main.java.order.service.application.port.out.ProductGrpcClientPort;
import main.java.order.service.domain.model.Order;
import main.java.order.service.domain.model.OrderProduct;
import main.java.order.service.domain.service.OrderDomainService;

@RequiredArgsConstructor
@Slf4j
public class OrderApplicationService implements CreateOrderPort, GetAllOrdersPort, GetProductPort {

    private final OrderDomainService orderService;
    private final OrderRepositoryPort orderRepositoryPort;
    private final ProductGrpcClientPort grpcClientPort;

    @Override
    public void createOrder(OrderProduct orderProduct) {
        Order order = orderService.generateOrderByProduct(orderProduct);
        orderRepositoryPort.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepositoryPort.getAllOrders();
    }

    @Override
    public OrderProduct getProductById(long id) {
        log.info("Product GET BY ID HIT :", id);
        return grpcClientPort.getProductById(id);
    }

}
