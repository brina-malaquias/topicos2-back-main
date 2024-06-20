package br.unitins.projeto.dto.produto.sabor;

import br.unitins.projeto.model.produto.Sabor;

public record SaborResponseDTO(
    Long id,
    String sabor
) {
    public static SaborResponseDTO valueOf(Sabor sabor) {
        return new SaborResponseDTO(
            sabor.getId(), 
            sabor.getSabor()
        );
    }
}