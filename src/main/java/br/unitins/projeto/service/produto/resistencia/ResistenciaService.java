package br.unitins.projeto.service.produto.resistencia;
import java.util.List;

import br.unitins.projeto.dto.produto.resistencia.ResistenciaDTO;
import br.unitins.projeto.dto.produto.resistencia.ResistenciaResponseDTO;
import jakarta.validation.Valid;

public interface ResistenciaService {
    
        // recursos basicos
        List<ResistenciaResponseDTO> getAll(int page, int pageSize);

        ResistenciaResponseDTO findById(Long id);
    
        ResistenciaResponseDTO create(@Valid ResistenciaDTO dto);
    
        ResistenciaResponseDTO update(Long id, ResistenciaDTO dto);
    
        void delete(Long id);
    
        // recursos extras
    
        List<ResistenciaResponseDTO> findByNome(String ohms);
    
        long count();
}
