package br.unitins.topicos2.ano2024.dto.produto;

import br.unitins.topicos2.ano2024.model.produto.Produto;

public record ProdutoResponseDTO(
        Long id,
        String nome,
        String descricao,
        Double valor,
        Integer estoque,
        Boolean ativo,

        String nomeImagem

) {
    public ProdutoResponseDTO(Produto entity) {
        this(entity.getId(),
        entity.getNome(),
        entity.getDescricao(),
        entity.getValor(),
        entity.getEstoque(),
        entity.getAtivo(),
        entity.getNomeImagem());
    }
}
