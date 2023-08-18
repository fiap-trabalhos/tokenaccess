package br.com.fiap.tokenaccess.validation;

import br.com.fiap.tokenaccess.entity.FiapTokenRequest;
import br.com.fiap.tokenaccess.exception.BadRequest;

public class FiapTokenRequestValidation {
    public static void validate(final FiapTokenRequest request) {
        if(request.cardNumber() == null) {
            throw new BadRequest("CreditCard number is invalid");
        }
        if(request.holder() == null) {
            throw new BadRequest("Holder number is invalid");
        }
        if(request.expiration() == null) {
            throw new BadRequest("Date Expiration number is invalid");
        }
        if(request.brand() == null) {
            throw new BadRequest("Brand number is invalid");
        }
    }
}