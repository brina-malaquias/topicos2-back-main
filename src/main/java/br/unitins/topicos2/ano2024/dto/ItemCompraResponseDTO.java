package br.unitins.topicos2.ano2024.dto;

import br.unitins.topicos2.ano2024.model.ItemCompra;

public record ItemCompraResponseDTO(

        Long id,

        Integer quantidade,

        Double preco,

        Long idProduto,

        String imagemProduto,

        String nome

) {

    public static ItemCompraResponseDTO valueOf(ItemCompra entity) {
        return new ItemCompraResponseDTO(entity.getId(),
                entity.getQuantidade(), entity.getValor(),
                entity.getProduto().getId(),
                entity.getProduto().getNomeImagem(),
                entity.getProduto().getNome());
    }

}
