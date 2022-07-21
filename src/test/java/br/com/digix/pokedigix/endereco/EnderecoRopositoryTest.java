package br.com.digix.pokedigix.endereco;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokedigix.tipo.TipoRepository;

@DataJpaTest
public class EnderecoRopositoryTest {
    
    @Autowired
    private EnderecoRopository enderecoRepository;

    @Test
    public void deve_salvar_um_endereco(){
        //Arrennge
        String cidadeEsperada = "Petalburg City";
        String regiaoEsperada = "Hoenn";
        Long idEsperado = 1L;
        

        //Act
        Endereco endereco = new Endereco(cidadeEsperada, regiaoEsperada);
        enderecoRepository.save(endereco);

        //Assert
        assertEquals(cidadeEsperada, endereco.getCidade());
        assertEquals(regiaoEsperada, endereco.getRegiao());
        assertEquals(idEsperado, endereco.getId());
    }
}
