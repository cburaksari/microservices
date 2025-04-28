package product.service.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import product.service.demo.grpc.ProductGrpcServiceImpl;

@Configuration
public class GrpcServerConfiguration {
    private final ProductGrpcServiceImpl productService;

    public GrpcServerConfiguration(ProductGrpcServiceImpl productService) {
        this.productService = productService;
    }

    @Bean(initMethod = "start", destroyMethod = "shutdown")
    public Server grpcServer() {
        return ServerBuilder.forPort(9090)
                .addService(productService)
                .build();
    }
}
