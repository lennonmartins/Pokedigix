package br.com.digix.pokedigix.treinador;

public class Treinador {
    private String nome;
    private double dinheiro;
    private int nivel;
    private int quantidade_pokemon;

    public Treinador(String nome, double dinheiro, int nivel, int quantidade_pokemon) {
        this.nome = nome;
        this.dinheiro = dinheiro;
        this.nivel = nivel;
        this.quantidade_pokemon = quantidade_pokemon; 
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
    public void setQuantidade_pokemon(int quantidade_pokemon) {
        this.quantidade_pokemon = quantidade_pokemon;
    }
    public int getQuantidade_pokemon() {
        return quantidade_pokemon;
    }
    
}
