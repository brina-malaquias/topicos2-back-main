package br.unitins.projeto.service.produto.marca;


import java.util.List;

import br.unitins.projeto.dto.produto.marca.MarcaDTO;
import br.unitins.projeto.dto.produto.marca.MarcaResponseDTO;
import jakarta.validation.Valid;

public interface MarcaService {

        // recursos basicos
        List<MarcaResponseDTO> getAll(int page, int pageSize);

        MarcaResponseDTO findById(Long id);
    
        MarcaResponseDTO create(@Valid MarcaDTO dto);
    
        MarcaResponseDTO update(Long id, MarcaDTO dto);
    
        void delete(Long id);
    
        // recursos extras
    
        List<MarcaResponseDTO> findByNome(String nome);
    
        long count();

}