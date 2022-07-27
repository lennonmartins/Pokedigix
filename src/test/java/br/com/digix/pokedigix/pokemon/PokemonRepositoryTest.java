package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;

import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.ataque.AtaqueBuilder;
import br.com.digix.pokedigix.tipo.Tipo;

@DataJpaTest
public class PokemonRepositoryTest {
    
    @Autowired
    private PokemonRepository pokemonRepository;
    private CrudRepository<Pokemon, Long> tipoRepository;

    @Test
    public void deve_adicionar_um_pokemon(){
        
        Pokemon pokemon = new PokemonBuilder().construir();

        pokemonRepository.save(pokemon);

        assertNotNull(pokemon.getId());
    }

    @Test
    public void deve_cadastrar_um_tipo_para_o_pokemon(){
        Tipo tiposEsperados = new Tipo("Psíquico");

        Pokemon pokemon = new PokemonBuilder().comTipo(tiposEsperados).construir();

        pokemonRepository.save(pokemon);

        assertTrue(pokemon.getTipos().contains(tiposEsperados));
    }

    @Test
    public void deve_salvar_um_pokemon_com_um_tipo(){
        int quantidadeDeTiposEsperada = 1;
        Tipo tipo = new Tipo("Psíquico");
        

        Pokemon pokemon = new PokemonBuilder().comTipo(tipo).construir();

        pokemonRepository.save(pokemon);

        Pokemon pokemonRetornados = pokemonRepository.findById(pokemon.getId()).get();

        assertNotNull(pokemonRetornados.getTipos());
        assertEquals(quantidadeDeTiposEsperada, pokemonRetornados.getTipos().size());
        assertTrue(pokemonRetornados.getTipos().contains(tipo));

    }

    @Test
    public void deve_salvar_um_pokemon_com_ataque(){
        Ataque ataque = new AtaqueBuilder().construir();
        Pokemon pokemon = new PokemonBuilder().comAtaque(ataque).construir();

        pokemonRepository.save(pokemon);

        assertTrue(pokemon.getAtaques().contains(ataque));
    }


}
