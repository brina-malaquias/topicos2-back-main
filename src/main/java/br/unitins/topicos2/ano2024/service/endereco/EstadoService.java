package br.unitins.topicos2.ano2024.service.endereco;

import java.util.List;

import br.unitins.topicos2.ano2024.dto.endereco.EstadoDTO;
import br.unitins.topicos2.ano2024.dto.endereco.EstadoResponseDTO;
import jakarta.validation.Valid;

public interface EstadoService {

        // recursos basicos
        List<EstadoResponseDTO> getAll(int page, int pageSize);

        EstadoResponseDTO findById(Long id);
    
        EstadoResponseDTO create(@Valid EstadoDTO dto);
    
        EstadoResponseDTO update(Long id, EstadoDTO dto);
    
        void delete(Long id);
    
        // recursos extras
    
        List<EstadoResponseDTO> findByNome(String nome);
    
        long count();

}
