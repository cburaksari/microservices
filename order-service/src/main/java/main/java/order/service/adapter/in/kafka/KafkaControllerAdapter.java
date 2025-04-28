package main.java.order.service.adapter.in.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import main.java.order.service.application.port.in.CreateOrderPort;
import main.java.order.service.domain.model.OrderProduct;

@Service
public class KafkaControllerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(KafkaControllerAdapter.class);
    @Qualifier("orderCommandAdapter")
    private final CreateOrderPort orderCommandPort;

    public KafkaControllerAdapter(CreateOrderPort orderCommandPort) {
        this.orderCommandPort = orderCommandPort;
    }

    @KafkaListener(topics = "product-topic", groupId = "order-consumer")
    public void createOrder(OrderProduct orderProduct) {
        logger.info("Received user event from Kafka: {}", orderProduct);
        orderCommandPort.createOrder(orderProduct);
    }
}
