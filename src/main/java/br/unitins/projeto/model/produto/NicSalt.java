package br.unitins.projeto.model.produto;


import java.util.List;

import br.unitins.projeto.model.Produto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class NicSalt extends Produto{

    @ManyToMany
    @JoinTable(name = "nicSalt_sabor", 
                joinColumns = @JoinColumn(name = "id_nicSalt"), 
                inverseJoinColumns = @JoinColumn(name = "id_sabor"))
    private List<Sabor> listaSabor;

    @ManyToMany
    @JoinTable(name = "nicSalt_marca", 
                joinColumns = @JoinColumn(name = "id_nicSalt"), 
                inverseJoinColumns = @JoinColumn(name = "id_marca"))
    private List<Marca> listaMarca;

    public List<Sabor> getListaSabor() {
        return listaSabor;
    }

    public void setListaSabor(List<Sabor> listaSabor) {
        this.listaSabor = listaSabor;
    }

    public List<Marca> getListaMarca() {
        return listaMarca;
    }

    public void setListaMarca(List<Marca> listaMarca) {
        this.listaMarca = listaMarca;
    }

}