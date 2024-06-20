package br.unitins.projeto.dto.produto.podRecarregavel;


import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record PodRecarregavelDTO(
    @NotBlank(message = "O campo nome não pode ser nulo.")
    String nome,
    Double valor,
    String descricao,
    List<Long> listaCor,
    List<Long> listaMarca

) {
    
}
