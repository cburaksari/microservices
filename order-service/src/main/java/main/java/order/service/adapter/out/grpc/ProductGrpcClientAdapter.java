package main.java.order.service.adapter.out.grpc;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import main.java.order.service.application.port.out.ProductGrpcClientPort;
import main.java.order.service.domain.model.OrderProduct;
import product.service.demo.grpc.GetProductRequest;
import product.service.demo.grpc.GetProductResponse;
import product.service.demo.grpc.ProductServiceGrpc;

@Component
@RequiredArgsConstructor
public class ProductGrpcClientAdapter implements ProductGrpcClientPort {

    private final ProductServiceGrpc.ProductServiceBlockingStub productServiceBlockingStub;

    @Override
    public OrderProduct getProductById(Long productId) {
        GetProductRequest request = GetProductRequest.newBuilder()
                .setProductId(productId)
                .build();

        GetProductResponse response = productServiceBlockingStub.getProductById(request);

        return new OrderProduct(
                response.getName(),
                response.getDescription(),
                Double.valueOf(response.getPrice()));
    }

}
