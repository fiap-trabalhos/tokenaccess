package br.com.fiap.tokenaccess.integration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CieloTokenRequest(
        @JsonProperty("CustomerName")
        String customerName,
        @JsonProperty("CardNumber")
        String cardNumber,
        @JsonProperty("Holder")
        String holder,
        @JsonProperty("ExpirationDate")
        String expirationDate,
        @JsonProperty("Brand")
        String brand
) {
}
