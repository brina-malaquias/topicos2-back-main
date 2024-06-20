package br.unitins.projeto.dto.produto.nicSalt;


import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record NicSaltDTO(
    @NotBlank(message = "O campo nome não pode ser nulo.")
    String nome,
    Double valor,
    String descricao,
    List<Long> listaSabor,
    List<Long> listaMarca
) {
    
}
