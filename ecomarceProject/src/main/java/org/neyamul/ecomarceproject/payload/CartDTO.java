package org.neyamul.ecomarceproject.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    private Long cartId;

    private Double totalPrice;

    private List<ProductDTO> products;
}
