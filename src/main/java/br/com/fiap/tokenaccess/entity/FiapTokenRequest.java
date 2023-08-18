package br.com.fiap.tokenaccess.entity;

public record FiapTokenRequest(
        String cardNumber,
        String holder,
        String expiration,
        String brand
) {
}