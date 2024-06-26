package br.unitins.projeto.dto.produto.coil;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.unitins.projeto.dto.produto.marca.MarcaDTO;
import br.unitins.projeto.dto.produto.resistencia.ResistenciaDTO;
import br.unitins.projeto.model.produto.Coil;


public record CoilResponseDTO(
    Long id,
    String nomeImagem,
    String nome,
    Double valor,
    String descricao,
    List<ResistenciaDTO> listaResistencia,
    List<MarcaDTO> listaMarca
) {
    public static CoilResponseDTO valueOf(Coil coil) {
        return new CoilResponseDTO(
            coil.getId(),
            coil.getNomeImagem(),
            coil.getNome(),
            coil.getValor(),
            coil.getDescricao(),
            Optional.ofNullable(coil.getListaResistencia())
                .map(resistenciaList -> resistenciaList.stream()
                    .map(resistencia -> new ResistenciaDTO(resistencia.getOhms()))
                    .collect(Collectors.toList())
                ).orElse(null),
            Optional.ofNullable(coil.getListaMarca())
                .map(marcaList -> marcaList.stream()
                    .map(marca -> new MarcaDTO(marca.getNome(),marca.getDescricao()))
                    .collect(Collectors.toList())
                ).orElse(null)
        );
    }
}

