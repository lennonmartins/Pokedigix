package br.com.digix.pokedigix.pokemon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.ataque.AtaqueBuilder;
import br.com.digix.pokedigix.tipo.Tipo;

public class PokemonBuilder {

    private Collection<Ataque> ataques;
    private int quantidadeDeTipos;
    private String nome;
    private int nivel;
    private int felicidade;
    private double altura;
    private double peso;
    private int numeroPokedex;
    private Collection<Tipo> tipos;
    private Genero genero;

    public PokemonBuilder(){
        this.quantidadeDeTipos = 1;
        this.nome = "Ralts";
        this.nivel = 11;
        this.felicidade = 25;
        this.altura = 0.40;
        this.peso = 7.0;
        this.numeroPokedex = 281;
        this.genero = Genero.F;
        this.tipos = new ArrayList<>();
        this.ataques = new ArrayList<>();
    }

    public PokemonBuilder comAtaque(Ataque ataque) {
        this.ataques.add(ataque);
        return this;
    }

    public Pokemon construir() {      
        return new Pokemon(nome, nivel, felicidade, altura, peso, numeroPokedex, genero, tipos, ataques);
    }

    public PokemonBuilder comTipo(Tipo tipo){
        this.tipos.add(tipo);
        return this;
    }
    
}
