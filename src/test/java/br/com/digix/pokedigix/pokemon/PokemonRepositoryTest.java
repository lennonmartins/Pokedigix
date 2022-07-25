package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokedigix.tipo.Tipo;

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
        Genero generoEsperado = Genero.F;
        List <Tipo> tiposEsperados = new ArrayList<>();
        tiposEsperados.add(new Tipo("Psíquico"));
        
        Pokemon pokemon = new Pokemon(nomeEsperado, nivelEsperado, felicidadeEsperada, alturaEsperado, pesoEsperado, numeroPokedexEsperado, generoEsperado, tiposEsperados);

        pokemonRepository.save(pokemon);

        assertNotNull(pokemon.getId());
    }

    @Test
    public void deve_cadastrar_um_tipo_para_o_pokemon(){
        String nomeEsperado = "Ralts";
        int nivelEsperado = 11;
        int felicidadeEsperada = 25;
        double alturaEsperado = 0.40;
        double pesoEsperado = 7.0;
        int numeroPokedexEsperado = 281;
        Genero generoEsperado = Genero.F;
        List <Tipo> tiposEsperados = new ArrayList<>();
        tiposEsperados.add(new Tipo("Psíquico"));

        Pokemon pokemon = new Pokemon(nomeEsperado, nivelEsperado, felicidadeEsperada, alturaEsperado, pesoEsperado, numeroPokedexEsperado, generoEsperado, tiposEsperados );

        pokemonRepository.save(pokemon);

        assertEquals(tiposEsperados, pokemon.getTipos());
    }

    @Test
    public void deve_verificar_se_tipo_nao_nulo(){
        String nomeEsperado = "Ralts";
        int nivelEsperado = 11;
        int felicidadeEsperada = 25;
        double alturaEsperado = 0.40;
        double pesoEsperado = 7.0;
        int numeroPokedexEsperado = 281;
        Genero generoEsperado = Genero.F;
        List <Tipo> tiposEsperados = new ArrayList<>();
        tiposEsperados.add(new Tipo("Psíquico"));

        Pokemon pokemon = new Pokemon(nomeEsperado, nivelEsperado, felicidadeEsperada, alturaEsperado, pesoEsperado, numeroPokedexEsperado, generoEsperado, tiposEsperados);

        pokemonRepository.save(pokemon);

        

        assertNotNull(pokemon.getTipos().iterator().next().getId());
    }


}
