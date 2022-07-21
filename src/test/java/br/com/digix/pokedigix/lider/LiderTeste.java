package br.com.digix.pokedigix.lider;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LiderTeste {
    
    @Test
    public void deve_verificar_um_lider(){
        //Arrenge
        String nomeEsperado = "Lennon Broks";
        Insignia insigniaEsperada = Insignia.MENTE; 
        int nivelEsperado = 74;

        Lider lider = new Lider(nomeEsperado, nivelEsperado, insigniaEsperada);

        assertEquals(nomeEsperado, lider.getNome());
        assertEquals(nivelEsperado, lider.getNivel());
        assertEquals(insigniaEsperada, lider.getInsignia());
        
    }
}
