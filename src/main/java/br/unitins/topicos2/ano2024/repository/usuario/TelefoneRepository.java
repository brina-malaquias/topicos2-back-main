package br.unitins.topicos2.ano2024.repository.usuario;


import jakarta.enterprise.context.ApplicationScoped;
import br.unitins.topicos2.ano2024.model.usuario.Telefone;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class TelefoneRepository implements PanacheRepository<Telefone> {
}
