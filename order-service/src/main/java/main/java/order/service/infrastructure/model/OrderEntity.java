package main.java.order.service.infrastructure.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import main.java.order.service.domain.model.Order;

@Entity
@Data
public class OrderEntity {

    @Id
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private OrderProductEntity orderProduct;

    private LocalDateTime expiryDate;

    public OrderEntity() {
    }

    public OrderEntity(Order order) {
        this.id = order.getId();
        this.name = order.getName();
        this.orderProduct = new OrderProductEntity(order.getOrderProduct());
        this.expiryDate = order.getExpiryDate();
    }
}
