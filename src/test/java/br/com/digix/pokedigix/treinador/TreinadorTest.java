package br.com.digix.pokedigix.treinador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TreinadorTest {
    @Test
    public void deve_adiciaonar_um_treinador(){
        String nomeEsperado = "Francisco Roberto";
        double dinheiroEsperado = 200;
        int nivelEsperado = 0;
        int quantidadePokemonEsperado = 0;

        Treinador triandor = new Treinador(nomeEsperado, dinheiroEsperado, nivelEsperado, quantidadePokemonEsperado);

        assertEquals(nomeEsperado, triandor.getNome());
        assertEquals(dinheiroEsperado, triandor.getDinheiro());
        assertEquals(nivelEsperado, triandor.getNivel());
        assertEquals(quantidadePokemonEsperado, triandor.getQuantidadePokemon());
    }
}
