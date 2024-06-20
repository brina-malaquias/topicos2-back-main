package br.unitins.projeto.service.produto.cor;


import java.util.List;

import br.unitins.projeto.dto.produto.cor.CorDTO;
import br.unitins.projeto.dto.produto.cor.CorResponseDTO;
import jakarta.validation.Valid;

public interface CorService {

        // recursos basicos
        List<CorResponseDTO> getAll(int page, int pageSize);

        CorResponseDTO findById(Long id);
    
        CorResponseDTO create(@Valid CorDTO dto);
    
        CorResponseDTO update(Long id, CorDTO dto);
    
        void delete(Long id);
    
        // recursos extras
    
        List<CorResponseDTO> findByNome(String cor);
    
        long count();
}
