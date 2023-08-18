package br.com.fiap.tokenaccess.integration;

import br.com.fiap.tokenaccess.configuration.FeignConfiguration;
import br.com.fiap.tokenaccess.integration.dto.CieloTokenRequest;
import br.com.fiap.tokenaccess.integration.dto.CieloTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "CieloToken",
        url = "${cielo.token.url}",
        configuration = FeignConfiguration.class
)
public interface CieloTokenWithFeign {
    @PostMapping(
            path = "/1/card/",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    CieloTokenResponse createToken(
            @RequestHeader("MerchantId") final String merchantId,
            @RequestHeader("MerchantKey") final String merchantKey,
            @RequestBody final CieloTokenRequest request);
}
