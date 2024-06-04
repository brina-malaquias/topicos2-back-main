package br.unitins.topicos2.ano2024.dto.endereco;

import br.unitins.topicos2.ano2024.model.endereco.Endereco;

public record EnderecoDTO(
    String logadouro,
    String bairro,
    String numero,
    String complemento,
    String cep
) {
    public static EnderecoDTO valueOf(Endereco endereco){
        return new EnderecoDTO(
            endereco.getLogradouro(),
            endereco.getBairro(),
            endereco.getNumero(),
            endereco.getComplemento(),
            endereco.getCep()
        );
    }
    
}