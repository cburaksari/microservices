package product.service.demo.service;

import java.util.List;

import product.service.demo.models.ProductCreateRequest;
import product.service.demo.models.ProductResponseDTO;

public interface IProductService {
    ProductResponseDTO createProduct(ProductCreateRequest productDTO);

    List<ProductResponseDTO> getAllProducts();
}
