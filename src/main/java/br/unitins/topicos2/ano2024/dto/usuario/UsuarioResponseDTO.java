package br.unitins.topicos2.ano2024.dto.usuario;

import java.util.List;
import java.util.Optional;

import br.unitins.topicos2.ano2024.dto.endereco.EnderecoDTO;
import br.unitins.topicos2.ano2024.model.usuario.TipoUsuario;
import br.unitins.topicos2.ano2024.model.usuario.Usuario;

public record UsuarioResponseDTO(
    Long id,
    String nome,
    String idade,
    String email,
    String senha,
    String cpf,
    TipoUsuario tipoUsuario,
    List<TelefoneDTO> listaTelefone,
    List<EnderecoDTO> listaEndereco

) {
    public static UsuarioResponseDTO valueOf(Usuario usuario){

        return new UsuarioResponseDTO(
            usuario.getId(), 
            usuario.getNome(),
            usuario.getIdade(),
            usuario.getEmail(),
            usuario.getSenha(),
            usuario.getCpf(),
            usuario.getTipoUsuario(),
                Optional.ofNullable(usuario.getListaTelefone())
                        .map(telefones -> telefones.stream().map(TelefoneDTO::valueOf).toList())
                        .orElse(null),
                Optional.ofNullable(usuario.getListaEndereco())
                        .map(endereco -> endereco.stream().map(EnderecoDTO::valueOf).toList())
                        .orElse(null)
        );
    }
}
