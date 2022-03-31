package org.onliner.spring.c51.dtoconverter;

import org.onliner.spring.c51.dto.seller.SellerSignupDTO;
import org.onliner.spring.c51.entity.Seller;
import org.onliner.spring.c51.entity.StateRegistrationInformation;

import java.time.ZoneId;

public class SellerDTOConverter {

    // ONL-12 : lombok
    public static Seller convertToSellerFromSellerDTOConverter(SellerSignupDTO sellerSignupDTO) {
        return Seller.builder()
                .stateRegistrationInformation(StateRegistrationInformation.builder()
                        .legalEntityName(sellerSignupDTO.getLegalEntityName())
                        .stateRegistrationLegalEntityPlace(sellerSignupDTO.getStateRegistrationLegalEntityPlace())
                        .payerAccountNumber(Integer.parseInt(sellerSignupDTO.getPayerAccountNumber()))
                        .stateRegistrationDate(sellerSignupDTO.getStateRegistrationDate()
                                .toInstant()
                                .atZone(ZoneId.systemDefault())
                                .toLocalDate())
                        .registrationAuthority(sellerSignupDTO.getRegistrationAuthority())
                        .entryTradeRegisterDate(sellerSignupDTO.getEntryTradeRegisterDate()
                                .toInstant()
                                .atZone(ZoneId.systemDefault())
                                .toLocalDate())
                        .build())
                .build();
    }
}
