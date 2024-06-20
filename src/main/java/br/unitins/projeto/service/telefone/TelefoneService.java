package br.unitins.projeto.service.telefone;


import jakarta.validation.Valid;
import java.util.List;

import br.unitins.projeto.dto.telefone.TelefoneDTO;
import br.unitins.projeto.dto.telefone.TelefoneResponseDTO;
import br.unitins.projeto.model.Telefone;



public interface TelefoneService {

    List<TelefoneResponseDTO> getAll();

    TelefoneResponseDTO findById(Long id);

    TelefoneResponseDTO create(TelefoneDTO productDTO);

    TelefoneResponseDTO update(Long id, TelefoneDTO productDTO);

    Telefone toModel(@Valid TelefoneDTO telefoneDTO);

    void delete(Long id);

    Long count();

}
