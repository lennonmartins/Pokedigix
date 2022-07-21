package br.com.digix.pokedigix.pokemon;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.digix.pokedigix.tipo.Tipo;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   
    @Column(nullable = false, length = 20)
    private String nome;
    
    @Column(nullable = false, length = 1)
    private String genero;
    
    private int nivel;
    
    private int felicidade;
    //private Tipo tipoPokemon;
    
    private double altura;
    private double peso;
    private int numeroPokedex;
    

    public Pokemon(String nome, int nivel, int felicidade,  double altura, double peso, int numeroPokedex, String genero) {
        this.nome = nome;
        this.nivel = nivel;
        this.felicidade = felicidade;
        this.altura = altura;
        this.peso = peso;
        this.numeroPokedex = numeroPokedex;
        this.genero = genero;
    }
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return this.nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public double getAltura() {
        return this.altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return this.peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
        
    public String getGenero() {
        return this.genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
   
    public int getNumeroPokedex() {
        return this.numeroPokedex;
    }
    public void setNumeroPokedex(int numeroPokedex) {
        this.numeroPokedex = numeroPokedex;
    }

    public int getFelicidade() {
        return this.felicidade;
    }
    public void setFelicidade(int felicidade) {
        this.felicidade = felicidade;
    }
	public Long getId() {
		return this.id;
	}
}
