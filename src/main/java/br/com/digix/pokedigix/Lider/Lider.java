package br.com.digix.pokedigix.lider;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.digix.pokedigix.endereco.Endereco;
import br.com.digix.pokedigix.personagm.Personagem;
import br.com.digix.pokedigix.pokemon.Pokemon;


@Entity
public class Lider extends Personagem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Insignia insignia;
   
    public Lider(String nome, Endereco endereco, Collection<Pokemon> pokemons, Insignia insignia) {
        super(nome, endereco);
        super.pokemons = pokemons;
        this.insignia = insignia;
    }

    public Insignia getInsignia() {
        return this.insignia;
    }

    public Long getId() {
        return this.id;
    }

}
