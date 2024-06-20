package br.unitins.projeto.model.produto;


import br.unitins.projeto.model.DefaultEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Sabor extends DefaultEntity {
    
    @Column(nullable = false)
    private String sabor;

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
}
