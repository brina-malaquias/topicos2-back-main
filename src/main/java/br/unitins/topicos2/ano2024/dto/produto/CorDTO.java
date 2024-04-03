package br.unitins.topicos2.ano2024.dto.produto;

import jakarta.validation.constraints.NotBlank;

public record CorDTO(
    @NotBlank(message = "O campo nome não pode ser nulo.")
    String cor
) {
}