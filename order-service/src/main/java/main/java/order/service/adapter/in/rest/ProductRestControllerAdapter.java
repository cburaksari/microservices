package main.java.order.service.adapter.in.rest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import main.java.order.service.application.port.in.GetProductPort;
import main.java.order.service.domain.model.OrderProduct;

@RestController
@RequestMapping("/api/products")
public class ProductRestControllerAdapter {
    @Qualifier("grpcProductAdapter")
    private final GetProductPort getProductPort;

    public ProductRestControllerAdapter(@Qualifier("grpcProductAdapter") GetProductPort getProductPort) {
        this.getProductPort = getProductPort;
    }

    @GetMapping("/getProduct")
    public OrderProduct getProduct(@RequestParam long productId) {
        return getProductPort.getProductById(productId);
    }
}
