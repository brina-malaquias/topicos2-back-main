package br.unitins.topicos2.ano2024.dto.endereco;

import br.unitins.topicos2.ano2024.model.endereco.Estado;

public record EstadoResponseDTO(
        Long id,
        String sigla,
        String nome) {

    public EstadoResponseDTO(Estado entity) {
        this(entity.getId(), entity.getSigla(), entity.getNome());
    }

}
