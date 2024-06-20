package br.unitins.projeto.repository.produto;


import br.unitins.projeto.model.produto.Sabor;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SaborRepository implements PanacheRepository<Sabor> {

    public PanacheQuery<Sabor> findByNome(String sabor) {
        if (sabor == null)
            return null;
        return find("UPPER(ohms) LIKE ?1 ", "%" + sabor.toUpperCase() + "%");
    }

}