package br.unitins.topicos2.ano2024.dto.usuario;

import br.unitins.topicos2.ano2024.model.usuario.Endereco;

public record EnderecoDTO(
    String cep,
    String bairro,
    String endereco,
    String numero,
    String complemento
) {
    public static EnderecoDTO valueOf(Endereco endereco){
        return new EnderecoDTO(
            endereco.getCep(),
            endereco.getBairro(),
            endereco.getEndereco(),
            endereco.getNumero(),
            endereco.getComplemento()
        );
    }
} 