package br.unitins.projeto.model.produto;


import java.util.List;

import br.unitins.projeto.model.Produto;
import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Coil extends Produto{

    @ManyToMany
    @JoinTable(name = "coil_resistencia", 
                joinColumns = @JoinColumn(name = "id_coil"), 
                inverseJoinColumns = @JoinColumn(name = "id_resistencia"))
    private List<Resistencia> listaResistencia;

    @ManyToMany
    @JoinTable(name = "coil_marca", 
                joinColumns = @JoinColumn(name = "id_coil"), 
                inverseJoinColumns = @JoinColumn(name = "id_marca"))
    private List<Marca> listaMarca;

    public List<Resistencia> getListaResistencia() {
        return listaResistencia;
    }

    public void setListaResistencia(List<Resistencia> listaResistencia) {
        this.listaResistencia = listaResistencia;
    }

    public List<Marca> getListaMarca() {
        return listaMarca;
    }

    public void setListaMarca(List<Marca> listaMarca) {
        this.listaMarca = listaMarca;
    }

    
}
