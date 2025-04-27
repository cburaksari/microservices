package main.java.order.service.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.order.service.infrastructure.model.OrderEntity;

@Repository
public interface OrderJPARepository extends JpaRepository<OrderEntity, Long> {

}
