package main.java.order.service.application.port.in;

import main.java.order.service.domain.model.OrderProduct;

public interface GetProductPort {
    OrderProduct getProductById(long id);
}
