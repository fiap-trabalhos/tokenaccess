package br.com.fiap.tokenaccess.function;

import br.com.fiap.tokenaccess.entity.FiapTokenRequest;
import br.com.fiap.tokenaccess.entity.FiapTokenResponse;
import br.com.fiap.tokenaccess.service.TokenCreditCardService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class TokenAccessFunction {
    @Bean
    public Function<FiapTokenRequest, FiapTokenResponse> generateToken(TokenCreditCardService service) {
        return service::createToken;
    }
}