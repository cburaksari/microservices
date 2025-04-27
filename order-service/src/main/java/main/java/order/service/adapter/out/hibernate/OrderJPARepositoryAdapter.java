package main.java.order.service.adapter.out.hibernate;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import main.java.order.service.application.port.out.OrderRepositoryPort;
import main.java.order.service.domain.model.Order;
import main.java.order.service.domain.model.OrderProduct;
import main.java.order.service.infrastructure.model.OrderEntity;
import main.java.order.service.infrastructure.persistence.OrderJPARepository;

@Service
@RequiredArgsConstructor
public class OrderJPARepositoryAdapter implements OrderRepositoryPort {
        private final OrderJPARepository orderRepository;

        @Override
        public Order save(Order order) {
                OrderEntity orderEntity = new OrderEntity(order);
                OrderEntity savedOrderEntity = orderRepository.save(orderEntity);
                return new Order(savedOrderEntity.getName(),
                                new OrderProduct(savedOrderEntity.getOrderProduct().getName(),
                                                savedOrderEntity.getOrderProduct().getDescription(),
                                                savedOrderEntity.getOrderProduct().getPrice()),
                                savedOrderEntity.getExpiryDate());
        }

        @Override
        public List<Order> getAllOrders() {
                List<OrderEntity> orderEntities = orderRepository.findAll();
                return orderEntities.stream()
                                .map(entity -> new Order(entity.getName(),
                                                new OrderProduct(entity.getOrderProduct().getName(),
                                                                entity.getOrderProduct().getDescription(),
                                                                entity.getOrderProduct().getPrice()),
                                                entity.getExpiryDate()))
                                .collect(Collectors.toList());
        }

}
