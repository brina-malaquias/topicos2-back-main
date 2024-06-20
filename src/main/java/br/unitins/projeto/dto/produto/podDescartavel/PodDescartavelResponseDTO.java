package br.unitins.projeto.dto.produto.podDescartavel;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.unitins.projeto.dto.produto.marca.MarcaDTO;
import br.unitins.projeto.dto.produto.puff.PuffDTO;
import br.unitins.projeto.dto.produto.sabor.SaborDTO;
import br.unitins.projeto.model.produto.PodDescartavel;

public record PodDescartavelResponseDTO(
    Long id,
    String nomeImagem,
    String nome,
    Double valor,
    String descricao,
    List<SaborDTO> listaSabor,
    List<PuffDTO> listaPuff,
    List<MarcaDTO> listaMarca
) {
    public static PodDescartavelResponseDTO valueOf(PodDescartavel podDescartavel) {
        return new PodDescartavelResponseDTO(
            podDescartavel.getId(),
            podDescartavel.getNomeImagem(),
            podDescartavel.getNome(),
            podDescartavel.getValor(),
            podDescartavel.getDescricao(),
            Optional.ofNullable(podDescartavel.getListaSabor())
                .map(saborList -> saborList.stream()
                    .map(sabor -> new SaborDTO(sabor.getSabor()))
                    .collect(Collectors.toList())
                ).orElse(null),
            Optional.ofNullable(podDescartavel.getListaPuff())
                .map(puffList -> puffList.stream()
                    .map(puff -> new PuffDTO(puff.getQuantidade()))
                    .collect(Collectors.toList())
                ).orElse(null),
            Optional.ofNullable(podDescartavel.getListaMarca())
                .map(marcaList -> marcaList.stream()
                    .map(marca -> new MarcaDTO(marca.getNome(),marca.getDescricao()))
                    .collect(Collectors.toList())
                ).orElse(null)
        );
    }
}