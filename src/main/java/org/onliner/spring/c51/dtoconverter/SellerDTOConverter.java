package org.onliner.spring.c51.dtoconverter;

import org.onliner.spring.c51.dto.seller.SellerSignupDTO;
import org.onliner.spring.c51.entity.Seller;
import org.onliner.spring.c51.entity.StateRegistrationInformation;

import java.time.ZoneId;

public class SellerDTOConverter {

    // ONL-12 : lombok
    public static Seller convertToSellerFromSellerDTOConverter(SellerSignupDTO sellerSignupDTO) {
        Seller seller = new Seller();

        StateRegistrationInformation stateRegistrationInformation = new StateRegistrationInformation();
        stateRegistrationInformation.setLegalEntityName(sellerSignupDTO.getLegalEntityName());
        stateRegistrationInformation.setStateRegistrationLegalEntityPlace(sellerSignupDTO.getStateRegistrationLegalEntityPlace());
        stateRegistrationInformation.setPayerAccountNumber(Integer.parseInt(sellerSignupDTO.getPayerAccountNumber()));
        stateRegistrationInformation.setStateRegistrationDate(sellerSignupDTO.getStateRegistrationDate()
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate());
        stateRegistrationInformation.setRegistrationAuthority(sellerSignupDTO.getRegistrationAuthority());
        stateRegistrationInformation.setEntryTradeRegisterDate(sellerSignupDTO.getEntryTradeRegisterDate()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate());
        return Seller.builder()
                .stateRegistrationInformation(stateRegistrationInformation)
                .build();
    }
}
