package br.unitins.topicos2.ano2024.dto.usuario;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos2.ano2024.dto.endereco.EnderecoResponseDTO;
import br.unitins.topicos2.ano2024.model.endereco.Endereco;
import br.unitins.topicos2.ano2024.model.usuario.Telefone;
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
    List<TelefoneResponseDTO> telefones,
    List<EnderecoResponseDTO> enderecos


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
            gerarTelefoneDTO(usuario.getListaTelefone()),
            gerarEnderecoDTO(usuario.getListaEndereco())
        );
    }

        public static List<EnderecoResponseDTO> gerarEnderecoDTO(List<Endereco> list) {
        if (list != null)
            return list.stream().map(EnderecoResponseDTO::new).collect(Collectors.toList());
        return null;
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
