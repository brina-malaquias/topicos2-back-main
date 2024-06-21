package br.unitins.projeto.dto.produto;

public record ProdutoDTO(

    String nome,
    String descricao,
    Double valor,
    Integer estoque
) {
}
