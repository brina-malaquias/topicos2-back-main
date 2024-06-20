package br.unitins.topicos2.ano2024.dto.usuario;


import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos2.ano2024.model.usuario.Telefone;
import br.unitins.topicos2.ano2024.model.usuario.Usuario;

public record UsuarioTelefoneResponseDTO(
        List<TelefoneResponseDTO> telefones
) {

    public static UsuarioTelefoneResponseDTO valueOf(Usuario entity) {
        return new UsuarioTelefoneResponseDTO(gerarTelefoneDTO(entity.getListaTelefone()));
    }

    public static List<TelefoneResponseDTO> gerarTelefoneDTO(List<Telefone> list) {
        if (list != null) {
            return list.stream()
                    .map(TelefoneResponseDTO::new)
                    .collect(Collectors.toList());
        }
        return null;
    }
}
