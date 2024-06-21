package br.unitins.projeto.service.produto.nicSalt;


import java.io.IOException;
import java.util.List;

import br.unitins.projeto.dto.produto.nicSalt.NicSaltDTO;
import br.unitins.projeto.dto.produto.nicSalt.NicSaltResponseDTO;
import br.unitins.projeto.form.NicSaltImageForm;
import jakarta.validation.Valid;

public interface NicSaltService {

        // recursos basicos
        List<NicSaltResponseDTO> getAll(int page, int pageSize);

        NicSaltResponseDTO findById(Long id);
    
        NicSaltResponseDTO create(@Valid NicSaltDTO dto);
    
        NicSaltResponseDTO update(Long id, NicSaltDTO dto);
    
        void delete(Long id);
    
        // recursos extras
    
        List<NicSaltResponseDTO> findByNome(String nome);
    
        long count();

        void salvarImagens(NicSaltImageForm imagens) throws IOException;


}