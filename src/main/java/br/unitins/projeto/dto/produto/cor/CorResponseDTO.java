package br.unitins.projeto.dto.produto.cor;

import br.unitins.projeto.model.produto.Cor;

public record CorResponseDTO(
    Long id,
    String cor
) {
    public static CorResponseDTO valueOf(Cor cor) {
        return new CorResponseDTO(
            cor.getId(), 
            cor.getCor()
        );
    }
}
