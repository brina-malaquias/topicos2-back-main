package br.unitins.topicos2.ano2024.model.produto;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.ManyToMany;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class PodDescartavel extends Produto{
        
    private String nomeImagem;
    private String nome;
    private Double valor;
    private String descricao;

    @ManyToMany
    @JoinTable(name = "puff_podDescartavel", 
                joinColumns = @JoinColumn(name = "id_podDescartavel"), 
                inverseJoinColumns = @JoinColumn(name = "id_puff"))
    private List<Puff> listaPuff;

    @ManyToMany
    @JoinTable(name = "sabor_podDescartavel", 
                joinColumns = @JoinColumn(name = "id_podDescartavel"), 
                inverseJoinColumns = @JoinColumn(name = "id_sabor"))
    private List<Sabor> listaSabor;

    @ManyToMany
    @JoinTable(name = "marca_podDescartavel", 
                joinColumns = @JoinColumn(name = "id_podDescartavel"), 
                inverseJoinColumns = @JoinColumn(name = "id_marca"))
    private List<Marca> listaMarca;

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Puff> getListaPuff() {
        return listaPuff;
    }

    public void setListaPuff(List<Puff> listaPuff) {
        this.listaPuff = listaPuff;
    }

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