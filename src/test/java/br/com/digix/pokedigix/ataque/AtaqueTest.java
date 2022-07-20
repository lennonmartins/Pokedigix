package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AtaqueTest {
    @Test
    void deve_criar_um_ataque(){
        //Arrange
        String nomeEsperado = "Confusão";
        int forcaEsperada = 95;
        double acuraciaEsperada = 100;
        int pontosDePoderEsperado = 35;
        String descricaoEsperada = "Causa confusão no oponente";
        Categoria categoriaEsperada = Categoria.ESPECIAL;

        //Act
        Ataque ataque = new Ataque(nomeEsperado, forcaEsperada, acuraciaEsperada, pontosDePoderEsperado, descricaoEsperada, categoriaEsperada);

        //Arrange
        assertEquals(nomeEsperado, ataque.getNome());
        assertEquals(forcaEsperada, ataque.getForca());
        assertEquals(acuraciaEsperada, ataque.getAcuracia());
        assertEquals(pontosDePoderEsperado, ataque.getPontosDePoder());
        assertEquals(descricaoEsperada, ataque.getDescricao());

    }
}
