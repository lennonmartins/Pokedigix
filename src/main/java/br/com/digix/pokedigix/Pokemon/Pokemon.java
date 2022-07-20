package br.com.digix.pokedigix.pokemon;

import br.com.digix.pokedigix.tipo.Tipo;

public class Pokemon {
    private String nome;
    private int nivel;
    private int felicidade;
    private Tipo tipoPokemon;
    private double altura;
    private double peso;
    private int numeroPokedex;
    private String genero;

    public Pokemon(String nome, int nivel, int felicidade, String tipo, double altura, double peso, int numeroPokedex,
            String genero) {
        this.nome = nome;
        this.nivel = nivel;
        this.felicidade = felicidade;
        this.altura = altura;
        this.peso = peso;
        this.numeroPokedex = numeroPokedex;
        this.genero = genero;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
        
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
   
    public int getNumeroPokedex() {
        return numeroPokedex;
    }
    public void setNumeroPokedex(int numeroPokedex) {
        this.numeroPokedex = numeroPokedex;
    }

    public int getFelicidade() {
        return felicidade;
    }
    public void setFelicidade(int felicidade) {
        this.felicidade = felicidade;
    }
}
