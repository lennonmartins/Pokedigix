package br.com.digix.pokedigix.treinador;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Treinador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 25)
    private String nome;

    @Column(nullable = false)
    private double dinheiro;

    @Column(nullable = false)
    private int nivel;

    @Column(nullable = false)
    private int quantidadePokemon;

    public Treinador(String nome, double dinheiro, int nivel, int quantidadePokemon) {
        this.nome = nome;
        this.dinheiro = dinheiro;
        this.nivel = nivel;
        this.quantidadePokemon = quantidadePokemon; 
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getDinheiro() {
        return dinheiro;
    }
    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public void setQuantidadePokemon(int quantidade_pokemon) {
        this.quantidadePokemon = quantidade_pokemon;
    }
    public int getQuantidadePokemon() {
        return quantidadePokemon;
    }

    public Long getId() {
        return id;
    }
    
}
