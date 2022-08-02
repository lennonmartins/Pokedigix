package br.com.digix.pokedigix.treinador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.endereco.Endereco;
import br.com.digix.pokedigix.pokemon.LimiteDeNivelException;
import br.com.digix.pokedigix.pokemon.Pokemon;
import br.com.digix.pokedigix.pokemon.PokemonBuilder;
import ch.qos.logback.core.joran.action.Action;

public class TreinadorTest {
    // @Test
    // public void deve_adiciaonar_um_treinador(){
    //     String nomeEsperado = "Francisco Roberto";
    //     double dinheiroEsperado = 200;
    //     int nivelEsperado = 0;
    //     int quantidadePokemonEsperado = 0;
    //     Endereco enderecoEsperado = new Endereco("Petalburg City", "Hoenn");

    //     Treinador treinador = new Treinador(nomeEsperado, dinheiroEsperado, nivelEsperado, quantidadePokemonEsperado, enderecoEsperado);

    //     assertEquals(nomeEsperado, treinador.getNome());
    //     assertEquals(dinheiroEsperado, treinador.getDinheiro());
    //     assertEquals(nivelEsperado, treinador.getNivel());
    //     assertEquals(quantidadePokemonEsperado, treinador.getQuantidadePokemon());
    //     assertEquals(enderecoEsperado, treinador.getEndereco());
    // }

    @Test
    public void deve_comecar_com_um_pokemon() throws Exception{
        int quantidadePokemonEsperado = 1;
        //Arrange
        Pokemon pokemonInicial = new PokemonBuilder().construir();

        //Action
        Treinador treinado = new TreinadorBuilder().comPokemonInicial(pokemonInicial).construir();

        //Assert
        assertTrue(treinado.getPokemons().contains(pokemonInicial));
        assertEquals(quantidadePokemonEsperado, treinado.getPokemons().size());
    }

    @Test
    public void deve_poder_capturar_um_pokemon() throws Exception{
        int quantidadeDeTiposEsperada = 2;
        Pokemon pokemonACapturar = new PokemonBuilder().construir();
        
        Treinador treinador= new TreinadorBuilder().construir();
        //Action
        treinador.capturar(pokemonACapturar);

        assertTrue(treinador.getPokemons().contains(pokemonACapturar));
        assertEquals(quantidadeDeTiposEsperada, treinador.getPokemons().size());

    }

    @Test
    public void nao_deve_capturar_maiS_que_seis_pokemons_ao_mesmo_tempo() throws Exception{
        Treinador treinador= new TreinadorBuilder().construir();
        for (int i = 1; i <= 5; i++){
             treinador.capturar(new PokemonBuilder().construir());
        }

        assertThrows(LimiteDePokemonException.class, () -> {
            treinador.capturar(new PokemonBuilder().construir());
        });
        
    }

    @Test
    public void deve_capturar_a_quantidade_limite_de_pokemons() throws Exception{
        int quantidadeDePokemonsEsperados = 6;
        Treinador treinador= new TreinadorBuilder().construir();
        
        for (int i = 1; i <= 5; i++){
             treinador.capturar(new PokemonBuilder().construir());
        }

        assertEquals(quantidadeDePokemonsEsperados,treinador.getPokemons().size());
    }
}
