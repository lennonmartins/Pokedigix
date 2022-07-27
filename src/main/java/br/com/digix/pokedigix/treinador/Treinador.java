package br.com.digix.pokedigix.treinador;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.digix.pokedigix.endereco.Endereco;
import br.com.digix.pokedigix.lider.Insignia;
import br.com.digix.pokedigix.personagm.Personagem;
import br.com.digix.pokedigix.pokemon.Pokemon;

@Entity
public class Treinador extends Personagem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int dinheiro;

    @Column(nullable = false)
    private int nivel;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Insignia.class )
    @Column(name = "insignia")
    private Collection<Insignia> insignias;

    
    public Treinador( String nome, Endereco endereco, Pokemon primeiroPokemon ) {
        super(nome, endereco);
        this.capturar(primeiroPokemon);
        this.dinheiro = 3000;
        this.nivel = 1;
    }
    
    private void capturar(Pokemon primeiroPokemon) {
        super.pokemons.add(primeiroPokemon);

    }

    public double getDinheiro() {
        return dinheiro;
    }
    
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
   
    public Long getId() {
        return id;
    }
    
}
