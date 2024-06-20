package br.unitins.projeto.repository.produto;


import br.unitins.projeto.model.produto.Resistencia;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ResistenciaRepository implements PanacheRepository<Resistencia> {

    public PanacheQuery<Resistencia> findByNome(String ohms) {
        if (ohms == null)
            return null;
        return find("UPPER(ohms) LIKE ?1 ", "%" + ohms.toUpperCase() + "%");
    }

}
