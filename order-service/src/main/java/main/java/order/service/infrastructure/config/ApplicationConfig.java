package main.java.order.service.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import main.java.order.service.adapter.out.hibernate.OrderJPARepositoryAdapter;
import main.java.order.service.application.port.in.CreateOrderPort;
import main.java.order.service.application.port.in.GetAllOrdersPort;
import main.java.order.service.application.port.out.OrderRepositoryPort;
import main.java.order.service.application.service.OrderApplicationService;
import main.java.order.service.domain.service.OrderDomainService;
import main.java.order.service.infrastructure.persistence.OrderJPARepository;

@Configuration
public class ApplicationConfig {
    @Bean
    public OrderDomainService orderService() {
        return new OrderDomainService();
    }

    @Bean
    public OrderApplicationService orderApplicationService(
            OrderDomainService orderService,
            OrderRepositoryPort orderRepositoryPort) {
        return new OrderApplicationService(orderService, orderRepositoryPort);
    }

    @Bean
    public GetAllOrdersPort orderQueryPort(OrderApplicationService orderApplicationService) {
        return orderApplicationService;
    }

    @Bean
    public CreateOrderPort orderCommandPort(OrderApplicationService orderApplicationService) {
        return orderApplicationService;
    }

    @Bean
    public OrderRepositoryPort orderRepositoryPort(OrderJPARepository orderJPARepository) {
        return new OrderJPARepositoryAdapter(orderJPARepository);
    }
}
