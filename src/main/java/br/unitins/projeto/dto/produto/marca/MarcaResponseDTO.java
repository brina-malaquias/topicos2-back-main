package br.unitins.projeto.dto.produto.marca;

import br.unitins.projeto.model.produto.Marca;

public record MarcaResponseDTO (
    Long id,
    String nome,
    String descricao
) {

    public static MarcaResponseDTO valueOf(Marca marca) {
        return new MarcaResponseDTO(
            marca.getId(), 
            marca.getNome(),
            marca.getDescricao()
        );
    }

}