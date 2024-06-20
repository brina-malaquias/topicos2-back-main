package br.unitins.projeto.dto.produto.resistencia;


import jakarta.validation.constraints.NotBlank;

public record ResistenciaDTO(
    @NotBlank(message = "O campo nome não pode ser nulo.")
    String ohms
) {
    
}
