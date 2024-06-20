package br.unitins.topicos2.ano2024.dto;


import java.util.List;

import br.unitins.topicos2.ano2024.dto.endereco.EnderecoCompraDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record CompraDTO(

        @Valid
        @NotNull(message = "O endereço da compra dever ser informado.")
        EnderecoCompraDTO enderecoCompra,

        @Valid
        @NotNull(message = "Os itens da compra devem ser informados.")
        List<ItemCompraDTO> itensCompra

) {
}
