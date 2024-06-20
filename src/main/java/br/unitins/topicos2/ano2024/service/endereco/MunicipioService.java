package br.unitins.topicos2.ano2024.service.endereco;

import java.util.List;

import br.unitins.topicos2.ano2024.dto.endereco.MunicipioDTO;
import br.unitins.topicos2.ano2024.dto.endereco.MunicipioResponseDTO;
import jakarta.validation.Valid;

public interface MunicipioService {

    List<MunicipioResponseDTO> getAll(int page, int pageSize);

    MunicipioResponseDTO findById(Long id);

    MunicipioResponseDTO create(@Valid MunicipioDTO productDTO);

    MunicipioResponseDTO update(Long id, @Valid MunicipioDTO productDTO);

    void delete(Long id);

    List<MunicipioResponseDTO> findByNome(String descricao, int page, int pageSize);

    Long count();

    Long countByNome(String nome);

    List<MunicipioResponseDTO> findByEstado(Long idEstado);
}
