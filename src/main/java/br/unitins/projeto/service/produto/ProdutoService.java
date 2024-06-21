package br.unitins.projeto.service.produto;

import java.io.IOException;
import java.util.List;

import br.unitins.projeto.dto.produto.ProdutoDTO;
import br.unitins.projeto.dto.produto.ProdutoResponseDTO;
import br.unitins.projeto.form.ProdutoImageForm;
import jakarta.validation.Valid;

public interface ProdutoService {
    
    List<ProdutoResponseDTO> getAll();

    ProdutoResponseDTO findById(Long id);

    ProdutoResponseDTO create(@Valid ProdutoDTO produtoDTO);

    ProdutoResponseDTO update(Long id, @Valid ProdutoDTO produtoDTO);

    void delete(Long id);



    List<ProdutoResponseDTO> findAllPaginado(int pageNumber, int pageSize);


    Long count();

    void salvarImagens(ProdutoImageForm imagens) throws IOException;

}
