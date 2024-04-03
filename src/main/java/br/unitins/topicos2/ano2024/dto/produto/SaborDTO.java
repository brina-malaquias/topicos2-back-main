package br.unitins.topicos2.ano2024.dto.produto;

import jakarta.validation.constraints.NotBlank;

public record SaborDTO(
    @NotBlank(message = "O campo nome não pode ser nulo.")
    String sabor
) {
}