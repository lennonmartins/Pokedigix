package br.com.digix.pokedigix.endereco;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EnderecoTest {
    @Test
    public void deve_poder_atribuir_um_endereco(){
        //Arrennge
        String cidadeEsperada = "Petalburg City";
        String regiaoEsperada = "Hoenn";

        //Act
        Endereco endereco = new Endereco(cidadeEsperada, regiaoEsperada);

        //Assert
        assertEquals(cidadeEsperada, endereco.getCidade());
        assertEquals(regiaoEsperada, endereco.getRegiao());


    }
}
