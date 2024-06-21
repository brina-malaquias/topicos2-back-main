package br.unitins.projeto.service.produto.podRecarregavel;

import java.io.IOException;
import java.io.NotActiveException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.unitins.projeto.dto.produto.podRecarregavel.PodRecarregavelDTO;
import br.unitins.projeto.dto.produto.podRecarregavel.PodRecarregavelResponseDTO;
import br.unitins.projeto.form.PodRecarregavelImageForm;
import br.unitins.projeto.model.produto.PodRecarregavel;
import br.unitins.projeto.repository.produto.CorRepository;
import br.unitins.projeto.repository.produto.MarcaRepository;
import br.unitins.projeto.repository.produto.PodRecarregavelRepository;
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
public class PodRecarregavelServiceImpl implements PodRecarregavelService{
    
    @Inject
    PodRecarregavelRepository podRecarregavelRepository;

    @Inject
    CorRepository corRepository;

    @Inject
    MarcaRepository marcaRepository;

    @Inject
    Validator validator;

    @Inject
    FileService fileService;
    
    @Override
    public List<PodRecarregavelResponseDTO> getAll(int page, int pageSize) {
        List<PodRecarregavel> list = podRecarregavelRepository
                                .findAll()
                                .page(page, pageSize)
                                .list();
        
        return list.stream().map(e -> PodRecarregavelResponseDTO.valueOf(e)).collect(Collectors.toList());
    }    
    
    @Override
    public PodRecarregavelResponseDTO findById(Long id) {
        PodRecarregavel podRecarregavel = podRecarregavelRepository.findById(id);
        if (podRecarregavel == null)
            throw new NotFoundException("PodRecarregavel não encontrado.");
        return PodRecarregavelResponseDTO.valueOf(podRecarregavel);
    }

    @Override
    @Transactional
    public PodRecarregavelResponseDTO create(@Valid PodRecarregavelDTO podRecarregavelDTO) throws ConstraintViolationException {
        //validar(PodRecarregavelDTO);

        PodRecarregavel entity = new PodRecarregavel();
        entity.setNome(podRecarregavelDTO.nome());
        entity.setValor(podRecarregavelDTO.valor());
        entity.setDescricao(podRecarregavelDTO.descricao());
        entity.setListaCor(podRecarregavelDTO.listaMarca().stream().map(id -> {
            return corRepository.findById(id);
        }).toList());
        entity.setListaMarca(podRecarregavelDTO.listaMarca().stream().map(id -> {
            return marcaRepository.findById(id);
        }).toList());

        podRecarregavelRepository.persist(entity);

        return PodRecarregavelResponseDTO.valueOf(entity);
    }

    @Override
    @Transactional
    public PodRecarregavelResponseDTO update(Long id, PodRecarregavelDTO podRecarregavelDTO) throws ConstraintViolationException{
        validar(podRecarregavelDTO);
   
        PodRecarregavel entity = podRecarregavelRepository.findById(id);

        entity.setNome(podRecarregavelDTO.nome());
        entity.setValor(podRecarregavelDTO.valor());
        entity.setDescricao(podRecarregavelDTO.descricao());

        return PodRecarregavelResponseDTO.valueOf(entity);
    }

    private void validar(PodRecarregavelDTO podRecarregavelDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<PodRecarregavelDTO>> violations = validator.validate(podRecarregavelDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        podRecarregavelRepository.deleteById(id);
    }

    @Override
    public List<PodRecarregavelResponseDTO> findByNome(String nome) {
    List<PodRecarregavel> list = podRecarregavelRepository.findByNome(nome).list();
    return list.stream().map(e -> PodRecarregavelResponseDTO.valueOf(e)).collect(Collectors.toList());
    }
    
    @Override
    public long count() {
        return podRecarregavelRepository.count();
    }

    
    @Override
    @Transactional
    public void salvarImagens(PodRecarregavelImageForm imagem) throws IOException {
        PodRecarregavel podRecarregavel = podRecarregavelRepository.findById(imagem.getId());

        if (podRecarregavel == null) {
            throw new NotActiveException("PodRecarregavel não encontrado");
        }

        try {
            String novoNomeImagem = fileService.salvarImagem(imagem.getImagem(), imagem.getNomeImagem(), "podRecarregavel");
            String imagemAntiga = podRecarregavel.getNomeImagem();
            podRecarregavel.setNomeImagem(novoNomeImagem);

            fileService.excluirImagem(imagemAntiga, "podRecarregavel");
        } catch (IOException e) {
            throw e;
        }
    }
    
}