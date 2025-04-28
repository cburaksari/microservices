package main.java.order.service.application.port.out;

import main.java.order.service.domain.model.OrderProduct;

public interface ProductGrpcClientPort {
    OrderProduct getProductById(Long productId);
}
