package br.unitins.topicos2.ano2024.service.endereco;


import java.util.List;

import br.unitins.topicos2.ano2024.dto.endereco.EnderecoCompraDTO;
import br.unitins.topicos2.ano2024.dto.endereco.EnderecoCompraResponseDTO;
import br.unitins.topicos2.ano2024.model.endereco.EnderecoCompra;
import jakarta.validation.Valid;

public interface EnderecoCompraService {

    List<EnderecoCompraResponseDTO> getAll();

    EnderecoCompraResponseDTO findById(Long id);

    EnderecoCompra create(EnderecoCompraDTO productDTO);
//
//    EnderecoCompra toEndereco(Long idEndereco);

    EnderecoCompra toModel(@Valid EnderecoCompraDTO dto);

}