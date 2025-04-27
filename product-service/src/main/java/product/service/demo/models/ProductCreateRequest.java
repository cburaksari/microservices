package product.service.demo.models;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductCreateRequest {

    private String name;

    private String description;

    private BigDecimal price;

    private Long sellerUserId;
}
