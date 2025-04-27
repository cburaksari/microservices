package main.java.order.service.infrastructure.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import main.java.order.service.domain.model.OrderProduct;

@Entity
@Data
public class OrderProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;

    public OrderProductEntity() {
    }

    public OrderProductEntity(OrderProduct orderProduct) {
        this.name = orderProduct.getName();
        this.price = orderProduct.getPrice();
    }
}
