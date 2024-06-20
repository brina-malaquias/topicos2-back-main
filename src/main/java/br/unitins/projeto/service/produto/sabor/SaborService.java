package br.unitins.projeto.service.produto.sabor;


import java.util.List;

import br.unitins.projeto.dto.produto.sabor.SaborDTO;
import br.unitins.projeto.dto.produto.sabor.SaborResponseDTO;
import jakarta.validation.Valid;

public interface SaborService {
    
        // recursos basicos
        List<SaborResponseDTO> getAll(int page, int pageSize);

        SaborResponseDTO findById(Long id);
    
        SaborResponseDTO create(@Valid SaborDTO dto);
    
        SaborResponseDTO update(Long id, SaborDTO dto);
    
        void delete(Long id);
    
        // recursos extras
    
        List<SaborResponseDTO> findByNome(String sabor);
    
        long count();
}
