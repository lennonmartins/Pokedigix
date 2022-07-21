package br.com.digix.pokedigix.telefone;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TelefoneTest {

    @Test
    public void deve_adiciaonar_um_telefone() {
        String telefoneEsperado = "+5567981373178";

        Telefone telefone = new Telefone(telefoneEsperado);

        assertEquals(telefoneEsperado, telefone.getTelefone());
    }

}
