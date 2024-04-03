package br.unitins.topicos2.ano2024.dto.produto;

import java.util.List;
import br.unitins.topicos2.ano2024.model.produto.PodDescartavel;


public record PodDescartavelResponseDTO(
    Long id,
    String nomeImagem,
    String nome,
    Double valor,
    String descricao,
    List<PuffDTO> listaPuff,
    List<SaborDTO> listaSabor,
    List<MarcaDTO> listaMarca

) {
    public static PodDescartavelResponseDTO valueOf(PodDescartavel podDescartavel){

        return new PodDescartavelResponseDTO(
            podDescartavel.getId(), 
            podDescartavel.getNomeImagem(),
            podDescartavel.getNome(),
            podDescartavel.getValor(),
            podDescartavel.getDescricao(),
            podDescartavel.getListaPuff(),
                    podDescartavel.getListaSabor(),
                        podDescartavel.getListaMarca()
        );
    }
}