package org.onliner.spring.c51.dto.seller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellerOfferDTO {
    private long sellerManagerId;
    private long productId;
    private double price;
}
