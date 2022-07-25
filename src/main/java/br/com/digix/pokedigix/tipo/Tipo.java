package br.com.digix.pokedigix.tipo;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import br.com.digix.pokedigix.pokemon.Pokemon;

@Entity
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false, length = 15)
    private String nome;

    @ManyToMany(mappedBy = "tipos")
    private Collection<Pokemon> pokemons; 

    //construtor;
    public Tipo(String nomeEsperado) {
        this.nome = nomeEsperado;
    }
   
    public Collection<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Collection<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public Object getNome() {
        return this.nome;
    }
    
    public void setId(Long id) {
            this.id = id;
    }

    public Long getId() {
        return this.id;
    }


}
