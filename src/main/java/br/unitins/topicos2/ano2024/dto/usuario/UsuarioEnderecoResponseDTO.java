package br.unitins.topicos2.ano2024.dto.usuario;


import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos2.ano2024.dto.endereco.EnderecoResponseDTO;
import br.unitins.topicos2.ano2024.model.endereco.Endereco;
import br.unitins.topicos2.ano2024.model.usuario.Usuario;
import jakarta.validation.Valid;

public record UsuarioEnderecoResponseDTO(

        @Valid List<EnderecoResponseDTO> listaEnderecos

) {

    public static UsuarioEnderecoResponseDTO valueOf(Usuario entity) {
        return new UsuarioEnderecoResponseDTO(gerarEnderecoDTO(entity.getListaEndereco()));
    }

    public static List<EnderecoResponseDTO> gerarEnderecoDTO(List<Endereco> list) {
        if (list != null)
            return list.stream().map(EnderecoResponseDTO::new).collect(Collectors.toList());
        return null;
    }

}