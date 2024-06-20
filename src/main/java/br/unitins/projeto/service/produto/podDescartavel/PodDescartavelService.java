package br.unitins.projeto.service.produto.podDescartavel;


import java.util.List;

import br.unitins.projeto.dto.produto.podDescartavel.PodDescartavelDTO;
import br.unitins.projeto.dto.produto.podDescartavel.PodDescartavelResponseDTO;
import jakarta.validation.Valid;

public interface PodDescartavelService {

        // recursos basicos
        List<PodDescartavelResponseDTO> getAll(int page, int pageSize);

        PodDescartavelResponseDTO findById(Long id);
    
        PodDescartavelResponseDTO create(@Valid PodDescartavelDTO dto);
    
        PodDescartavelResponseDTO update(Long id, PodDescartavelDTO dto);
    
        void delete(Long id);
    
        // recursos extras
    
        List<PodDescartavelResponseDTO> findByNome(String nome);
    
        long count();
}