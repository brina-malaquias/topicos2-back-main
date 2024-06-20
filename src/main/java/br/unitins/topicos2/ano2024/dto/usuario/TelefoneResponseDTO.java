package br.unitins.topicos2.ano2024.dto.usuario;

import br.unitins.topicos2.ano2024.model.usuario.Telefone;

public record TelefoneResponseDTO(
        Long id,
        String codigoArea,
        String numero) {

    public TelefoneResponseDTO(Telefone entity) {
        this(entity.getId(), entity.getCodigoArea(), entity.getNumero());
    }

}
