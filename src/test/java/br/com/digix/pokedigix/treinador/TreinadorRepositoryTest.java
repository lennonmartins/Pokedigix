package br.com.digix.pokedigix.treinador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokedigix.endereco.Endereco;
import br.com.digix.pokedigix.tipo.TipoRepository;

@DataJpaTest
public class TreinadorRepositoryTest {
    
    @Autowired
    private TreinadorRepository treinadorRepository;

    @Test
    public void deve_salvar_um_treinador() throws Exception{
    Treinador treinador = new TreinadorBuilder().construir();

    treinadorRepository.save(treinador);

    assertNotNull(treinador.getId());
        
    }

    
}
