package main.java.order.service.adapter.in.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import main.java.order.service.application.port.in.CreateOrderPort;
import main.java.order.service.domain.model.OrderProduct;

@Service
@RequiredArgsConstructor
public class KafkaControllerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(KafkaControllerAdapter.class);
    private final CreateOrderPort orderCommandPort;

    @KafkaListener(topics = "product-topic", groupId = "order-consumer")
    public void createOrder(OrderProduct orderProduct) {
        logger.info("Received user event from Kafka: {}", orderProduct);
        orderCommandPort.createOrder(orderProduct);
    }
}
