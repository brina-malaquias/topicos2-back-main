package br.unitins.topicos2.ano2024.model.usuario;

import br.unitins.topicos2.ano2024.model.DefaultEntity;
import jakarta.persistence.Column;

public class Endereco extends DefaultEntity {

    @Column(nullable = false)
    private String cep;
    private String bairro;
    private String endereco;
    private String numero;
    private String complemento;


    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
}
