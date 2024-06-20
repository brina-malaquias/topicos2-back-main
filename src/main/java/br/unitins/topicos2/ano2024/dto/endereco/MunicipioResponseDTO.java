package br.unitins.topicos2.ano2024.dto.endereco;

import br.unitins.topicos2.ano2024.model.endereco.Estado;
import br.unitins.topicos2.ano2024.model.endereco.Municipio;

public record MunicipioResponseDTO(
        Long id,
        String nome,
        EstadoResponseDTO estado) {

    public MunicipioResponseDTO(Municipio entity) {
        this(entity.getId(), entity.getNome(), gerarEstadoDTO(entity.getEstado()));
    }

    public static EstadoResponseDTO gerarEstadoDTO(Estado estado) {
        EstadoResponseDTO estadoResponseDTO = new EstadoResponseDTO(estado);
        return estadoResponseDTO;
    }

}