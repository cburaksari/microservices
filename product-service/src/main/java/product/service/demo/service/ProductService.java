package product.service.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import product.service.demo.models.Product;
import product.service.demo.models.ProductCreateRequest;
import product.service.demo.models.ProductResponseDTO;
import product.service.demo.models.ProductUser;
import product.service.demo.repository.ProductRepository;
import product.service.demo.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
        private final ProductRepository productRepository;
        private final UserRepository userRepository;

        @Override
        public ProductResponseDTO createProduct(ProductCreateRequest request) {
                ProductUser user = userRepository.findById(request.getSellerUserId())
                                .orElseThrow(() -> new RuntimeException("User not found in product-service"));

                Product product = new Product(
                                null,
                                request.getName(),
                                request.getDescription(),
                                request.getPrice(),
                                user);

                Product saved = productRepository.save(product);
                return new ProductResponseDTO(
                                saved.getId(),
                                saved.getName(),
                                saved.getDescription(),
                                saved.getPrice(),
                                user.getName());
        }

        @Override
        public List<ProductResponseDTO> getAllProducts() {
                return productRepository.findAll()
                                .stream()
                                .map(product -> new ProductResponseDTO(product.getId(), product.getName(),
                                                product.getDescription(),
                                                product.getPrice(), product.getUser().getName()))
                                .collect(Collectors.toList());
        }

}
