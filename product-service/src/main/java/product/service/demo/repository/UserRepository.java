package product.service.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import product.service.demo.models.ProductUser;

@Repository
public interface UserRepository extends JpaRepository<ProductUser, Long> {

}
