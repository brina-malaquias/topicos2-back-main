package br.unitins.projeto.service.produto.podRecarregavel;


import java.util.List;

import br.unitins.projeto.dto.produto.podRecarregavel.PodRecarregavelDTO;
import br.unitins.projeto.dto.produto.podRecarregavel.PodRecarregavelResponseDTO;
import jakarta.validation.Valid;

public interface PodRecarregavelService {

        // recursos basicos
        List<PodRecarregavelResponseDTO> getAll(int page, int pageSize);

        PodRecarregavelResponseDTO findById(Long id);
    
        PodRecarregavelResponseDTO create(@Valid PodRecarregavelDTO dto);
    
        PodRecarregavelResponseDTO update(Long id, PodRecarregavelDTO dto);
    
        void delete(Long id);
    
        // recursos extras
    
        List<PodRecarregavelResponseDTO> findByNome(String nome);
    
        long count();
}