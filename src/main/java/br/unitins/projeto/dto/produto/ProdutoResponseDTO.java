package br.unitins.projeto.dto.produto;

import br.unitins.projeto.model.Produto;

public record ProdutoResponseDTO(
        Long id,
        String nome,
        String descricao,
        Double valor,
        Integer estoque,

        String nomeImagem

) {
    public ProdutoResponseDTO(Produto entity) {
        this(entity.getId(),
        entity.getNome(),
        entity.getDescricao(),
        entity.getValor(),
        entity.getEstoque(),

        entity.getNomeImagem());
    }
}
