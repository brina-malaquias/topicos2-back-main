package br.unitins.topicos2.ano2024.dto.endereco;

import br.unitins.topicos2.ano2024.model.endereco.Estado;

public record EstadoResponseDTO (
    Long id,
    String nome,
    String sigla
) {

    public static EstadoResponseDTO valueOf(Estado estado) {
        return new EstadoResponseDTO(
            estado.getId(), 
            estado.getNome(),
            estado.getSigla()
        );
    }

}