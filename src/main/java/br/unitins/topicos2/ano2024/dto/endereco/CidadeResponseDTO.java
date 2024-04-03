package br.unitins.topicos2.ano2024.dto.endereco;

import br.unitins.topicos2.ano2024.model.endereco.Cidade;

public record CidadeResponseDTO(
        Long id,
        String nome,
        EstadoResponseDTO estado) {

    public static CidadeResponseDTO valueOf(Cidade cidade) {
        return new CidadeResponseDTO(
                cidade.getId(),
                cidade.getNome(),
                EstadoResponseDTO.valueOf(cidade.getEstado()));
    }

}
