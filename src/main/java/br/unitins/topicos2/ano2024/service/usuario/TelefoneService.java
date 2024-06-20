package br.unitins.topicos2.ano2024.service.usuario;

import jakarta.validation.Valid;
import java.util.List;

import br.unitins.topicos2.ano2024.dto.usuario.TelefoneDTO;
import br.unitins.topicos2.ano2024.dto.usuario.TelefoneResponseDTO;
import br.unitins.topicos2.ano2024.model.usuario.Telefone;

public interface TelefoneService {

    List<TelefoneResponseDTO> getAll();

    TelefoneResponseDTO findById(Long id);

    TelefoneResponseDTO create(TelefoneDTO productDTO);

    TelefoneResponseDTO update(Long id, TelefoneDTO productDTO);

    Telefone toModel(@Valid TelefoneDTO telefoneDTO);

    void delete(Long id);

    Long count();

}
