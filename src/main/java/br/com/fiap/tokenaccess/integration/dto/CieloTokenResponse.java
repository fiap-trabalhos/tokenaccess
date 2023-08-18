package br.com.fiap.tokenaccess.integration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CieloTokenResponse(
        @JsonProperty("CardToken")
        String cardToken
) {
}
