package br.unitins.projeto.dto.produto.nicSalt;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.unitins.projeto.dto.produto.marca.MarcaDTO;
import br.unitins.projeto.dto.produto.sabor.SaborDTO;
import br.unitins.projeto.model.produto.NicSalt;

public record NicSaltResponseDTO(
    Long id,
    String nomeImagem,
    String nome,
    Double valor,
    String descricao,
    List<SaborDTO> listaSabor,
    List<MarcaDTO> listaMarca
) {
    public static NicSaltResponseDTO valueOf(NicSalt nicSalt) {
        return new NicSaltResponseDTO(
            nicSalt.getId(),
            nicSalt.getNomeImagem(),
            nicSalt.getNome(),
            nicSalt.getValor(),
            nicSalt.getDescricao(),
            Optional.ofNullable(nicSalt.getListaSabor())
                .map(saborList -> saborList.stream()
                    .map(sabor -> new SaborDTO(sabor.getSabor()))
                    .collect(Collectors.toList())
                ).orElse(null),
            Optional.ofNullable(nicSalt.getListaMarca())
                .map(marcaList -> marcaList.stream()
                    .map(marca -> new MarcaDTO(marca.getNome(),marca.getDescricao()))
                    .collect(Collectors.toList())
                ).orElse(null)
        );
    }
}
