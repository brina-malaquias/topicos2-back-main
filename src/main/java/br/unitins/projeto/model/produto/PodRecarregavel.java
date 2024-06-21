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
public class PodRecarregavel extends Produto{

    @ManyToMany
    @JoinTable(name = "podRecarregavel_cor", 
                joinColumns = @JoinColumn(name = "id_podRecarregavel"), 
                inverseJoinColumns = @JoinColumn(name = "id_cor"))
    private List<Cor> listaCor;

    @ManyToMany
    @JoinTable(name = "podRecarregavel_marca", 
                joinColumns = @JoinColumn(name = "id_podRecarregavel"), 
                inverseJoinColumns = @JoinColumn(name = "id_marca"))
    private List<Marca> listaMarca;

    public List<Cor> getListaCor() {
        return listaCor;
    }

    public void setListaCor(List<Cor> listaCor) {
        this.listaCor = listaCor;
    }

    public List<Marca> getListaMarca() {
        return listaMarca;
    }

    public void setListaMarca(List<Marca> listaMarca) {
        this.listaMarca = listaMarca;
    }

    
}
