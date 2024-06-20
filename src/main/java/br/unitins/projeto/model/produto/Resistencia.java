package br.unitins.projeto.model.produto;


import br.unitins.projeto.model.DefaultEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Resistencia extends DefaultEntity {
    
    @Column(nullable = false)
    private String ohms;

    public String getOhms() {
        return ohms;
    }

    public void setOhms(String ohms) {
        this.ohms = ohms;
    }
}
