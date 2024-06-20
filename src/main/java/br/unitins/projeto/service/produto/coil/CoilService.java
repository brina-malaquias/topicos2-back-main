package br.unitins.projeto.service.produto.coil;


import java.util.List;

import br.unitins.projeto.dto.produto.coil.CoilDTO;
import br.unitins.projeto.dto.produto.coil.CoilResponseDTO;
import jakarta.validation.Valid;

public interface CoilService {
    
    // recursos basicos
    List<CoilResponseDTO> getAll(int page, int pageSize);

    CoilResponseDTO findById(Long id);

    CoilResponseDTO create(@Valid CoilDTO dto);

    CoilResponseDTO update(Long id, CoilDTO dto);

    void delete(Long id);

    // recursos extras

    List<CoilResponseDTO> findByNome(String nome);

    long count();
}