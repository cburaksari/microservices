package api.gateway.demo.logging;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Order(1)
@Slf4j
public class LoggingFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
            org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {
        long startTime = System.currentTimeMillis();

        String method = exchange.getRequest().getMethod().name();
        String path = exchange.getRequest().getURI().getPath();
        System.out.println("Request Method: " + method + ", Request Path: " + path);

        return chain.filter(exchange)
                .doOnTerminate(() -> {
                    long executionTime = System.currentTimeMillis() - startTime;
                    System.out.println("Request completed in " + executionTime + " ms");
                })
                .doOnError(throwable -> System.out.println("Error occurred, cause: " + throwable.getMessage()));
    }
}