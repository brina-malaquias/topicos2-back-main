package br.unitins.projeto.repository.produto;


import br.unitins.projeto.model.produto.Cor;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CorRepository implements PanacheRepository<Cor> {

    public PanacheQuery<Cor> findByNome(String cor) {
        if (cor == null)
            return null;
        return find("UPPER(cor) LIKE ?1 ", "%" + cor.toUpperCase() + "%");
    }

}
