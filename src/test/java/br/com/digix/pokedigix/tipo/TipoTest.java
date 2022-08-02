package br.com.digix.pokedigix.tipo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.pokemon.Pokemon;
import br.com.digix.pokedigix.pokemon.PokemonBuilder;
import br.com.digix.pokedigix.tipo.Tipo;
import br.com.digix.pokedigix.treinador.Treinador;
import br.com.digix.pokedigix.treinador.TreinadorBuilder;

public class TipoTest {
    @Test
    public void deve_poder_criar_um_tipo(){
        //Arrange 
        String nomeEsperado = "Psíquico";

        //Act
        Tipo tipo = new Tipo(nomeEsperado);

        //Assert
        assertEquals(nomeEsperado, tipo.getNome());

    }

   
}
