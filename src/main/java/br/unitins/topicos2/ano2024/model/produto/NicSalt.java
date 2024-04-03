package br.unitins.topicos2.ano2024.model.produto;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

@PrimaryKeyJoinColumn(name = "id")
public class NicSalt extends Produto {
    
    private String nomeImagem;
    private String nome;
    private Double valor;
    private String descricao;

    @OneToMany
    @JoinTable(name = "sabor_nicSalt", 
                joinColumns = @JoinColumn(name = "id_nicSalt"), 
                inverseJoinColumns = @JoinColumn(name = "id_sabor"))
    private List<Sabor> sabores;

    @OneToMany
    @JoinTable(name = "marca_nicSalt", 
                joinColumns = @JoinColumn(name = "id_nicSalt"), 
                inverseJoinColumns = @JoinColumn(name = "id_marca"))
    private List<Marca> marcas;

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

    public List<Sabor> getSabores() {
        return sabores;
    }

    public void setSabores(List<Sabor> sabores) {
        this.sabores = sabores;
    }

    public void plusSabores(Sabor sabor) {
        
        if (sabores == null) {

            sabores = new ArrayList<>();
        }
        
        this.sabores.add(sabor);
    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

    public void plusMarcas(Marca marca) {
        
        if (marcas == null) {

            marcas = new ArrayList<>();
        }
        
        this.marcas.add(marca);
    }

}
