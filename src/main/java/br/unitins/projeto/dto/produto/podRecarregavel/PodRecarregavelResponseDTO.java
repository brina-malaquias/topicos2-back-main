package br.unitins.projeto.dto.produto.podRecarregavel;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.unitins.projeto.dto.produto.cor.CorDTO;
import br.unitins.projeto.dto.produto.marca.MarcaDTO;
import br.unitins.projeto.model.produto.PodRecarregavel;

public record PodRecarregavelResponseDTO(
    Long id,
    String nomeImagem,
    String nome,
    Double valor,
    String descricao,
    List<CorDTO> listaCor,
    List<MarcaDTO> listaMarca
) {
    public static PodRecarregavelResponseDTO valueOf(PodRecarregavel podRecarregavel) {
        return new PodRecarregavelResponseDTO(
            podRecarregavel.getId(),
            podRecarregavel.getNomeImagem(),
            podRecarregavel.getNome(),
            podRecarregavel.getValor(),
            podRecarregavel.getDescricao(),
            Optional.ofNullable(podRecarregavel.getListaCor())
                .map(corList -> corList.stream()
                    .map(cor -> new CorDTO(cor.getCor()))
                    .collect(Collectors.toList())
                ).orElse(null),
            Optional.ofNullable(podRecarregavel.getListaMarca())
                .map(marcaList -> marcaList.stream()
                    .map(marca -> new MarcaDTO(marca.getNome(),marca.getDescricao()))
                    .collect(Collectors.toList())
                ).orElse(null)
        );
    }
}