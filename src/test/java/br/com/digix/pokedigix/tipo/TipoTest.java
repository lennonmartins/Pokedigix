package br.com.digix.pokedigix.tipo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.tipo.Tipo;

public class TipoTest {
    @Test
    public void deve_poder_criar_um_tipo(){
        //Arrange 
        String nomeEsperado = "Psíquico";

        //Act
        Tipo tipo = new Tipo(nomeEsperado);

        //Arrange
        assertEquals(nomeEsperado, tipo.getNome());

    }
}
