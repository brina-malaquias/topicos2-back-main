package br.unitins.topicos2.ano2024.service.endereco;

import java.util.List;
import br.unitins.topicos2.ano2024.dto.endereco.EnderecoDTO;
import br.unitins.topicos2.ano2024.model.endereco.Endereco;
import br.unitins.topicos2.ano2024.model.usuario.Usuario;
import br.unitins.topicos2.ano2024.repository.endereco.EnderecoRepository;
import java.util.List;
import java.util.Set;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class EnderecoImplService implements EnderecoService {
    
    @Inject
    EnderecoRepository enderecoRepository;

    @Inject
    Validator validator;

    @Override
    @Transactional
    public Endereco insertEndereco(EnderecoDTO enderecoDto) throws ConstraintViolationException {
        
        validar(enderecoDto);

        Endereco endereco = new Endereco();

        endereco.setLogradouro(enderecoDto.logadouro());

        endereco.setBairro(enderecoDto.bairro());

        endereco.setNumero(enderecoDto.numero());

        endereco.setComplemento(enderecoDto.complemento());

        endereco.setCep(enderecoDto.cep());

        enderecoRepository.persist(endereco);

        return endereco;
    }

    @Override
    @Transactional
    public void updateEndereco(Usuario usuario, EnderecoDTO enderecoDTO) throws ConstraintViolationException {

        Long idEndereco = usuario.getEndereco().getId();

        usuario.setEndereco(insertEndereco(enderecoDTO));

        deleteEndereco(idEndereco);
    }


    private void deleteEndereco(Long id) throws NotFoundException, IllegalArgumentException {
        
        if (id == null)
            throw new IllegalArgumentException("Número inválido");

        Endereco endereco = enderecoRepository.findById(id);

        if (enderecoRepository.isPersistent(endereco))
            enderecoRepository.delete(endereco);

        else
            throw new NotFoundException("Nenhum endereço encontrado");
    }

    private void validar(EnderecoDTO enderecoDTO) throws ConstraintViolationException {

        Set<ConstraintViolation<EnderecoDTO>> violations = validator.validate(enderecoDTO);

        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

    }
}