package br.unitins.projeto.repository.produto;


import br.unitins.projeto.model.produto.PodDescartavel;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PodDescartavelRepository implements PanacheRepository<PodDescartavel>{
    
    public PanacheQuery<PodDescartavel> findByNome(String nome) {
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%" + nome.toUpperCase() + "%");
    }
}
