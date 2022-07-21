package br.com.digix.pokedigix.telefone;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class TelefoneRepositoryTest {

    @Autowired
    private TelefoneRepository telefoneRepository;
    
    @Test
    public void deve_salvar_um_telefone(){
        String telefoneEsperado = "+5567981373178";
        Long idEsperado = 1L;
        
        Telefone telefone = new Telefone(telefoneEsperado);
        telefoneRepository.save(telefone);
        

        assertEquals(idEsperado, telefone.getId());
    }
}
