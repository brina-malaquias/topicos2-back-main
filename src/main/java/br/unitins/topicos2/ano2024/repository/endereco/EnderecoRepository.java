package br.unitins.topicos2.ano2024.repository.endereco;


import java.util.List;

import br.unitins.topicos2.ano2024.model.endereco.Endereco;
import jakarta.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class EnderecoRepository implements PanacheRepository<Endereco> {
    
    public List<Endereco> findByCEP(String cep){
        if (cep == null)
            return null;
        return find("UPPER(cep) LIKE ?1 ", "%"+cep.toUpperCase()+"%").list();
    }

}
