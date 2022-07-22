package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PokemonRepositoryTest {
    
    @Autowired
    private PokemonRepository pokemonRepository;
    @Test
    public void deve_adicionar_um_pokemon(){
        String nomeEsperado = "Ralts";
        int nivelEsperado = 11;
        int felicidadeEsperada = 25;
        double alturaEsperado = 0.40;
        double pesoEsperado = 7.0;
        int numeroPokedexEsperado = 281;
        String generoEsperado = "F";
        
        Pokemon pokemon = new Pokemon(nomeEsperado, nivelEsperado, felicidadeEsperada, alturaEsperado, pesoEsperado, numeroPokedexEsperado, generoEsperado);
        pokemonRepository.save(pokemon);

        assertNotNull(pokemon.getId());
    }
}
