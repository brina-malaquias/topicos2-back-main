package br.unitins.topicos2.ano2024.repository.endereco;

import java.util.List;

import br.unitins.topicos2.ano2024.model.endereco.Estado;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EstadoRepository implements PanacheRepository<Estado> {
    
    public List<Estado> findBySigla(String sigla){
        if (sigla == null)
            return null;
        return find("UPPER(sigla) LIKE ?1 ", "%"+sigla.toUpperCase()+"%").list();
    }

    public PanacheQuery<Estado> findByFiltro(String nome, Boolean ativo) {
        if (nome != null && ativo != null) {
            return find("UPPER(nome) LIKE ?1 AND ativo = ?2 ", "%" + nome.toUpperCase() + "%", ativo);
        }

        if (nome != null && ativo == null) {
            return find("UPPER(nome) LIKE ?1 ", "%" + nome.toUpperCase() + "%");
        }

        if (nome == null && ativo != null) {
            return find("ativo = ?1 ", "%" + nome.toUpperCase() + "%", ativo);
        }

        return null;
    }

}
