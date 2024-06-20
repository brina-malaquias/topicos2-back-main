package br.unitins.topicos2.ano2024.dto.usuario;


import java.util.List;

import br.unitins.topicos2.ano2024.dto.endereco.EnderecoDTO;
import jakarta.validation.Valid;

public record UsuarioEnderecoDTO(

        @Valid List<EnderecoDTO> listaEnderecos

) {

}
