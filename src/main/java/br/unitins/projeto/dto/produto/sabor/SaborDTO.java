package br.unitins.projeto.dto.produto.sabor;



import jakarta.validation.constraints.NotBlank;

public record SaborDTO(
    @NotBlank(message = "O campo nome não pode ser nulo.")
    String sabor
) {
}