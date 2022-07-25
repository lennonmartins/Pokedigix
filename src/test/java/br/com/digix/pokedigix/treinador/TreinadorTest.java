package br.com.digix.pokedigix.treinador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.endereco.Endereco;

public class TreinadorTest {
    @Test
    public void deve_adiciaonar_um_treinador(){
        String nomeEsperado = "Francisco Roberto";
        double dinheiroEsperado = 200;
        int nivelEsperado = 0;
        int quantidadePokemonEsperado = 0;
        Endereco enderecoEsperado = new Endereco("Petalburg City", "Hoenn");

        Treinador treinador = new Treinador(nomeEsperado, dinheiroEsperado, nivelEsperado, quantidadePokemonEsperado, enderecoEsperado);

        assertEquals(nomeEsperado, treinador.getNome());
        assertEquals(dinheiroEsperado, treinador.getDinheiro());
        assertEquals(nivelEsperado, treinador.getNivel());
        assertEquals(quantidadePokemonEsperado, treinador.getQuantidadePokemon());
        assertEquals(enderecoEsperado, treinador.getEndereco());
    }
}
