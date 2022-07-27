package br.com.digix.pokedigix.lider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class LiderRepositoryTest {
    
    @Autowired
    private LiderRepository liderRepository;

    // @Test
    // public void deve_adicionar_um_lider(){
    //     String nomeEsperado = "Lennon Broks";
    //     Insignia insigniaEsperada = Insignia.MENTE; 
    //     int nivelEsperado = 74;

    //     Lider lider = new Lider(nomeEsperado, nivelEsperado, insigniaEsperada);
    //     liderRepository.save(lider);

    //     assertNotNull(lider.getId());
    // }
}
