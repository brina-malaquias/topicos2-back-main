package br.unitins.projeto.service.produto.puff;


import java.util.List;

import br.unitins.projeto.dto.produto.puff.PuffDTO;
import br.unitins.projeto.dto.produto.puff.PuffResponseDTO;
import jakarta.validation.Valid;

public interface PuffService {

        // recursos basicos
        List<PuffResponseDTO> getAll(int page, int pageSize);

        PuffResponseDTO findById(Long id);
    
        PuffResponseDTO create(@Valid PuffDTO dto);
    
        PuffResponseDTO update(Long id, PuffDTO dto);
    
        void delete(Long id);
    
        // recursos extras
    
        List<PuffResponseDTO> findByNome(String quantidade);
    
        long count();
}