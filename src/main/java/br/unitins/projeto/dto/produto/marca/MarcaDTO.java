package br.unitins.projeto.dto.produto.marca;


import jakarta.validation.constraints.NotBlank;

public record MarcaDTO(
    @NotBlank(message = "O campo nome não pode ser nulo.")
    String nome,
    @NotBlank(message = "O campo descrição não pode ser nulo.")
    String descricao
) {
    
}
