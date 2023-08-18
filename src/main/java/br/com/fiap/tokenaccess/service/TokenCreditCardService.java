package br.com.fiap.tokenaccess.service;

import br.com.fiap.tokenaccess.entity.FiapTokenRequest;
import br.com.fiap.tokenaccess.entity.FiapTokenResponse;
import br.com.fiap.tokenaccess.integration.CieloTokenWithFeign;
import br.com.fiap.tokenaccess.integration.dto.CieloTokenRequest;
import br.com.fiap.tokenaccess.integration.dto.CieloTokenResponse;
import br.com.fiap.tokenaccess.repository.TokenRepositoryWithDynamodb;
import br.com.fiap.tokenaccess.repository.orm.TokenOrm;
import br.com.fiap.tokenaccess.validation.FiapTokenRequestValidation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TokenCreditCardService {
    private final String merchantId;
    private final String merchantKey;
    private final TokenRepositoryWithDynamodb repository;
    private final CieloTokenWithFeign cieloTokenWithFeign;

    public TokenCreditCardService(
            TokenRepositoryWithDynamodb repository,
            CieloTokenWithFeign cieloTokenWithFeign,
            @Value("${cielo.merchant-id}") String merchantId,
            @Value("${cielo.merchant-key}") String merchantKey) {
        this.merchantId = merchantId;
        this.repository = repository;
        this.merchantKey = merchantKey;
        this.cieloTokenWithFeign = cieloTokenWithFeign;
    }

    public FiapTokenResponse createToken(final FiapTokenRequest request) {
        FiapTokenRequestValidation.validate(request);
        CieloTokenResponse tokenResponse = authPaymentGateway(request);
        TokenOrm orm = saveToken(tokenResponse.cardToken());
        return new FiapTokenResponse(orm.getCardToken());
    }

    private CieloTokenResponse authPaymentGateway(final FiapTokenRequest request) {
        return cieloTokenWithFeign.createToken(
                merchantId,
                merchantKey,
                createCieloRequest(request));
    }

    private CieloTokenRequest createCieloRequest(final FiapTokenRequest request) {
        return new CieloTokenRequest(
                request.holder(),
                request.cardNumber(),
                request.holder(),
                request.expiration(),
                request.brand()
        );
    }

    private TokenOrm saveToken(final String cardToken) {
        TokenOrm orm = new TokenOrm();
        orm.setId(UUID.randomUUID().toString());
        orm.setCardToken(cardToken);
        return repository.save(orm);
    }
}