package br.unitins.projeto.dto.produto.podDescartavel;


import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record PodDescartavelDTO(
    @NotBlank(message = "O campo nome não pode ser nulo.")
    String nome,
    Double valor,
    String descricao,
    List<Long> listaSabor,
    List<Long> listaPuff,
    List<Long> listaMarca
) {
    
}
