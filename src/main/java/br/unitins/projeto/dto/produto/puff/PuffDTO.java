package br.unitins.projeto.dto.produto.puff;


import jakarta.validation.constraints.NotBlank;

public record PuffDTO(
    @NotBlank(message = "O campo nome não pode ser nulo.")
    String quantidade
) {
    
}