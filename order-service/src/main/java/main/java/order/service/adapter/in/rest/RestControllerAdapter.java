package main.java.order.service.adapter.in.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import main.java.order.service.application.port.in.GetAllOrdersPort;
import main.java.order.service.domain.model.Order;

@RestController
@RequestMapping("/api/orders")
public class RestControllerAdapter {

    private final GetAllOrdersPort orderQueryPort;

    public RestControllerAdapter(@Qualifier("orderQueryAdapter") GetAllOrdersPort orderQueryPort) {
        this.orderQueryPort = orderQueryPort;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderQueryPort.getAllOrders();
        return ResponseEntity.ok(orders);
    }
}
