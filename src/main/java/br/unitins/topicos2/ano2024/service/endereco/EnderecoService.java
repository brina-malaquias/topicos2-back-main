package br.unitins.topicos2.ano2024.service.endereco;


import java.util.List;

import br.unitins.topicos2.ano2024.dto.endereco.EnderecoDTO;
import br.unitins.topicos2.ano2024.dto.endereco.EnderecoResponseDTO;
import br.unitins.topicos2.ano2024.dto.endereco.EnderecoUpdateDTO;
import br.unitins.topicos2.ano2024.model.endereco.Endereco;
import jakarta.validation.Valid;


public interface EnderecoService {

    List<EnderecoResponseDTO> getAll();

    EnderecoResponseDTO findById(Long id);

    EnderecoResponseDTO create(EnderecoDTO productDTO);

    EnderecoResponseDTO create(Endereco product);

    EnderecoResponseDTO update(Long id, EnderecoUpdateDTO productDTO);

    Endereco toModel(@Valid EnderecoDTO enderecoDTO);

    Endereco toUpdateModel(@Valid EnderecoUpdateDTO enderecoDTO);

    void delete(Long id);

    List<EnderecoResponseDTO> findByCEP(String cep);

    Long count();

}