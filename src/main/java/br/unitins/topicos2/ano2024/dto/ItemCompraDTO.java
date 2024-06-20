package br.unitins.topicos2.ano2024.dto;


import jakarta.validation.constraints.NotNull;

public record ItemCompraDTO(

        @NotNull(message = "O campo quantidade deve ser informado.")
        Integer quantidade,

        Double valor,

        @NotNull(message = "O produto deve ser informado.")
        Long idProduto

) {
}
