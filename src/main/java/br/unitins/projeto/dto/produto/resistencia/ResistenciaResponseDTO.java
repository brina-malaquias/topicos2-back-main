package br.unitins.projeto.dto.produto.resistencia;

import br.unitins.projeto.model.produto.Resistencia;

public record ResistenciaResponseDTO(
    Long id,
    String ohms
) {
    public static ResistenciaResponseDTO valueOf(Resistencia resistencia) {
        return new ResistenciaResponseDTO(
            resistencia.getId(), 
            resistencia.getOhms()
        );
    }

}
