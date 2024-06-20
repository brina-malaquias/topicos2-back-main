package br.unitins.topicos2.ano2024.dto.produto;


public record ProdutoDTO(

    String nome,
    String descricao,
    Double valor,
    Integer estoque,
    Boolean ativo

) {
}
