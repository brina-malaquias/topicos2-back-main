package br.unitins.projeto.dto.produto.puff;

import br.unitins.projeto.model.produto.Puff;

public record PuffResponseDTO(
    Long id,
    String quantidade
) {
    public static PuffResponseDTO valueOf(Puff puff) {
        return new PuffResponseDTO(
            puff.getId(), 
            puff.getQuantidade()
        );
    }
}