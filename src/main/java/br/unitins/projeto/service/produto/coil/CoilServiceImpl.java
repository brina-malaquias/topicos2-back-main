package br.unitins.projeto.service.produto.coil;


import java.io.IOException;
import java.io.NotActiveException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.unitins.projeto.dto.produto.coil.CoilDTO;
import br.unitins.projeto.dto.produto.coil.CoilResponseDTO;
import br.unitins.projeto.form.CoilImageForm;
import br.unitins.projeto.model.produto.Coil;
import br.unitins.projeto.repository.produto.CoilRepository;
import br.unitins.projeto.repository.produto.MarcaRepository;
import br.unitins.projeto.repository.produto.ResistenciaRepository;
import br.unitins.projeto.service.file.FileService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class CoilServiceImpl implements CoilService{
    @Inject
    CoilRepository coilRepository;

    @Inject
    ResistenciaRepository resistenciaRepository;

    @Inject
    MarcaRepository marcaRepository;

    @Inject
    Validator validator;

    @Inject
    FileService fileService;
    
    @Override
    public List<CoilResponseDTO> getAll(int page, int pageSize) {
        List<Coil> list = coilRepository
                                .findAll()
                                .page(page, pageSize)
                                .list();
        
        return list.stream().map(e -> CoilResponseDTO.valueOf(e)).collect(Collectors.toList());
    }    
    
    @Override
    public CoilResponseDTO findById(Long id) {
        Coil coil = coilRepository.findById(id);
        if (coil == null)
            throw new NotFoundException("Coil não encontrado.");
        return CoilResponseDTO.valueOf(coil);
    }

    @Override
    @Transactional
    public CoilResponseDTO create(@Valid CoilDTO coilDTO) throws ConstraintViolationException {
        //validar(CoilDTO);

        Coil entity = new Coil();
        entity.setNome(coilDTO.nome());
        entity.setValor(coilDTO.valor());
        entity.setDescricao(coilDTO.descricao());
        entity.setListaResistencia(coilDTO.listaResistencia().stream().map(id -> {
            return resistenciaRepository.findById(id);
        } ).toList());
        entity.setListaMarca(coilDTO.listaMarca().stream().map(id -> {
            return marcaRepository.findById(id);
        }).toList());

        coilRepository.persist(entity);

        return CoilResponseDTO.valueOf(entity);
    }

    @Override
    @Transactional
    public CoilResponseDTO update(Long id, CoilDTO coilDTO) throws ConstraintViolationException{
        validar(coilDTO);
   
        Coil entity = coilRepository.findById(id);

        entity.setNome(coilDTO.nome());
        entity.setValor(coilDTO.valor());
        entity.setDescricao(coilDTO.descricao());

        return CoilResponseDTO.valueOf(entity);
    }

    private void validar(CoilDTO coilDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<CoilDTO>> violations = validator.validate(coilDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        coilRepository.deleteById(id);
    }

    @Override
    public List<CoilResponseDTO> findByNome(String nome) {
    List<Coil> list = coilRepository.findByNome(nome).list();
    return list.stream().map(e -> CoilResponseDTO.valueOf(e)).collect(Collectors.toList());
    }
    
    @Override
    public long count() {
        return coilRepository.count();
    }

    
    @Override
    @Transactional
    public void salvarImagens(CoilImageForm imagem) throws IOException {
        Coil coil = coilRepository.findById(imagem.getId());

        if (coil == null) {
            throw new NotActiveException("Coil não encontrado");
        }

        try {
            String novoNomeImagem = fileService.salvarImagem(imagem.getImagem(), imagem.getNomeImagem(), "coil");
            String imagemAntiga = coil.getNomeImagem();
            coil.setNomeImagem(novoNomeImagem);

            fileService.excluirImagem(imagemAntiga, "coil");
        } catch (IOException e) {
            throw e;
        }
    }
    
}