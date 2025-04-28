package product.service.demo.grpc;

import org.springframework.stereotype.Component;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import product.service.demo.models.Product;
import product.service.demo.repository.ProductRepository;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductGrpcServiceImpl extends ProductServiceGrpc.ProductServiceImplBase {

    private final ProductRepository productRepository;

    @Override
    public void getProductById(GetProductRequest request, StreamObserver<GetProductResponse> responseObserver) {
        log.info("Grpc server HIT for product ID: ", request.getProductId());
        Product product = productRepository.findById(request.getProductId()).orElse(null);

        if (product == null) {
            responseObserver.onError(new RuntimeException("Product not found"));
            return;
        }

        GetProductResponse response = GetProductResponse.newBuilder()
                .setId(product.getId())
                .setName(product.getName())
                .setDescription(product.getDescription())
                .setPrice(product.getPrice() != null ? product.getPrice().intValue() : null)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
