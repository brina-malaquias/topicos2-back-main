package br.unitins.topicos2.ano2024.service.endereco;



import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.unitins.topicos2.ano2024.dto.endereco.EnderecoDTO;
import br.unitins.topicos2.ano2024.dto.endereco.EnderecoResponseDTO;
import br.unitins.topicos2.ano2024.dto.endereco.EnderecoUpdateDTO;
import br.unitins.topicos2.ano2024.model.endereco.Endereco;
import br.unitins.topicos2.ano2024.repository.endereco.EnderecoRepository;
import br.unitins.topicos2.ano2024.repository.endereco.MunicipioRepository;

@ApplicationScoped
public class EnderecoServiceImpl implements EnderecoService {

    @Inject
    EnderecoRepository repository;

    @Inject
    MunicipioRepository municipioRepository;

    @Inject
    Validator validator;

    @Override
    public List<EnderecoResponseDTO> getAll() {
        List<Endereco> list = repository.listAll();
        return list.stream().map(EnderecoResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public EnderecoResponseDTO findById(Long id) {
        Endereco endereco = repository.findById(id);

        if (endereco == null)
            throw new NotFoundException("Endereço não encontrado.");

        return new EnderecoResponseDTO(endereco);
    }

    @Override
    @Transactional
    public EnderecoResponseDTO create(EnderecoDTO enderecoDTO) throws ConstraintViolationException {
        validar(enderecoDTO);

        Endereco entity = new Endereco();

        entity.setPrincipal(enderecoDTO.principal());
        entity.setLogradouro(enderecoDTO.logradouro());
        entity.setBairro(enderecoDTO.bairro());
        entity.setNumero(enderecoDTO.numero());
        entity.setComplemento(enderecoDTO.complemento());
        entity.setCep(enderecoDTO.cep());
        entity.setTitulo(enderecoDTO.titulo());
        entity.setMunicipio(municipioRepository.findById(enderecoDTO.idMunicipio()));

        repository.persist(entity);

        return new EnderecoResponseDTO(entity);
    }

    @Override
    @Transactional
    public EnderecoResponseDTO create(Endereco endereco) throws ConstraintViolationException {
        repository.persist(endereco);
        return new EnderecoResponseDTO(endereco);
    }

    @Override
    @Transactional
    public EnderecoResponseDTO update(Long id, EnderecoUpdateDTO enderecoDTO) throws ConstraintViolationException {
        validar(enderecoDTO);

        Endereco entity = repository.findById(id);

        entity.setPrincipal(enderecoDTO.principal());
        entity.setLogradouro(enderecoDTO.logradouro());
        entity.setBairro(enderecoDTO.bairro());
        entity.setNumero(enderecoDTO.numero());
        entity.setComplemento(enderecoDTO.complemento());
        entity.setCep(enderecoDTO.cep());
        entity.setTitulo(enderecoDTO.titulo());
        entity.setMunicipio(municipioRepository.findById(enderecoDTO.idMunicipio()));

        return new EnderecoResponseDTO(entity);
    }

    @Override
    public Endereco toModel(@Valid EnderecoDTO enderecoDTO) {
        Endereco entity = new Endereco();

        entity.setPrincipal(enderecoDTO.principal());
        entity.setLogradouro(enderecoDTO.logradouro());
        entity.setBairro(enderecoDTO.bairro());
        entity.setNumero(enderecoDTO.numero());
        entity.setComplemento(enderecoDTO.complemento());
        entity.setCep(enderecoDTO.cep());
        entity.setTitulo(enderecoDTO.titulo());
        entity.setMunicipio(municipioRepository.findById(enderecoDTO.idMunicipio()));

        return entity;
    }

    @Override
    public Endereco toUpdateModel(EnderecoUpdateDTO enderecoDTO) {
        Endereco entity = new Endereco();

        entity.setId(enderecoDTO.id());
        entity.setPrincipal(enderecoDTO.principal());
        entity.setLogradouro(enderecoDTO.logradouro());
        entity.setBairro(enderecoDTO.bairro());
        entity.setNumero(enderecoDTO.numero());
        entity.setComplemento(enderecoDTO.complemento());
        entity.setCep(enderecoDTO.cep());
        entity.setTitulo(enderecoDTO.titulo());
        entity.setMunicipio(municipioRepository.findById(enderecoDTO.idMunicipio()));

        return entity;
    }

    private void validar(EnderecoDTO enderecoDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<EnderecoDTO>> violations = validator.validate(enderecoDTO);

        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }

    private void validar(EnderecoUpdateDTO enderecoDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<EnderecoUpdateDTO>> violations = validator.validate(enderecoDTO);

        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<EnderecoResponseDTO> findByCEP(String cep) {
        List<Endereco> list = repository.findByCEP(cep);
        return list.stream().map(EnderecoResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public Long count() {
        return repository.count();
    }

}