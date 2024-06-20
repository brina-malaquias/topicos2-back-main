package br.unitins.topicos2.ano2024.dto;


import jakarta.validation.constraints.NotNull;

public record StatusCompraDTO(

        @NotNull(message = "O novo status da compra deve ser informado.")
        Integer statusCompra

) {
}
