package main.java.order.service.infrastructure.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import main.java.order.service.adapter.out.grpc.ProductGrpcClientAdapter;
import main.java.order.service.adapter.out.hibernate.OrderJPARepositoryAdapter;
import main.java.order.service.application.port.in.CreateOrderPort;
import main.java.order.service.application.port.in.GetAllOrdersPort;
import main.java.order.service.application.port.in.GetProductPort;
import main.java.order.service.application.port.out.OrderRepositoryPort;
import main.java.order.service.application.port.out.ProductGrpcClientPort;
import main.java.order.service.application.service.OrderApplicationService;
import main.java.order.service.domain.service.OrderDomainService;
import main.java.order.service.infrastructure.persistence.OrderJPARepository;
import product.service.demo.grpc.ProductServiceGrpc;

@Configuration
public class ApplicationConfig {
    @Bean
    public OrderDomainService orderService() {
        return new OrderDomainService();
    }

    @Bean
    public OrderApplicationService orderApplicationService(
            OrderDomainService orderService,
            OrderRepositoryPort orderRepositoryPort,
            ProductGrpcClientPort productGrpcClientPort) {
        return new OrderApplicationService(orderService, orderRepositoryPort, productGrpcClientPort);
    }

    @Bean
    @Qualifier("orderQueryAdapter")
    public GetAllOrdersPort orderQueryPort(OrderApplicationService orderApplicationService) {
        return orderApplicationService;
    }

    @Bean
    @Qualifier("orderCommandAdapter")
    public CreateOrderPort orderCommandPort(OrderApplicationService orderApplicationService) {
        return orderApplicationService;
    }

    @Bean
    @Qualifier("grpcProductAdapter")
    public GetProductPort grpcPort(OrderApplicationService orderApplicationService) {
        return orderApplicationService;
    }

    @Bean
    public OrderRepositoryPort orderRepositoryPort(OrderJPARepository orderJPARepository) {
        return new OrderJPARepositoryAdapter(orderJPARepository);
    }

    @Bean
    public ProductGrpcClientPort productGrpcClientPort(
            ProductServiceGrpc.ProductServiceBlockingStub productServiceBlockingStub) {
        return new ProductGrpcClientAdapter(productServiceBlockingStub);
    }
}
