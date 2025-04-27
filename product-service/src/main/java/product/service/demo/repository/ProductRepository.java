package product.service.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import product.service.demo.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
