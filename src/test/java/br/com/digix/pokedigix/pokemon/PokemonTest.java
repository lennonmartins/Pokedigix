package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.tipo.Tipo;

public class PokemonTest {
    
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

        Pokemon pokemon = new PokemonBuilder().construir();


        assertEquals(nomeEsperado, pokemon.getNome());
        assertEquals(nivelEsperado, pokemon.getNivel());
        assertEquals(felicidadeEsperada, pokemon.getFelicidade());
        assertEquals(alturaEsperado, pokemon.getAltura());
        assertEquals(pesoEsperado, pokemon.getPeso());
        assertEquals(numeroPokedexEsperado, pokemon.getNumeroPokedex());
        assertEquals(generoEsperado, pokemon.getGenero());

    }

    @Test
    public  void deve_cadastrar_um_tipo_para_o_pokemon(){
        Tipo tipo = new Tipo("Fada");

        Pokemon pokemon = new PokemonBuilder().comTipo(tipo).construir();


        assertTrue(pokemon.getTipos().contains(tipo));
    }

    @Test
    public void deve_adicionar_um_ataque_para_o_pokemon(){
        
    }
}
