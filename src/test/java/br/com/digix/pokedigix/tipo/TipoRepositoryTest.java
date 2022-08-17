package br.com.digix.pokedigix.tipo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class TipoRepositoryTest {

    @Autowired
    private TipoRepository tipoRepository;

    @Test
    public void deve_salvar_um_tipo(){
        //Arrange
        String nomeEsperado = "Psíquico";
        
        //Act
        Tipo tipo = new Tipo(nomeEsperado);
        tipoRepository.save(tipo);

        //Assert
        assertNotNull(tipo.getId());
    }

    @Test 
    public void deve_buscar_um_tipo_pelo_nome(){
        String nomeEsperado = "Aquatico";

        Tipo tipo = new Tipo(nomeEsperado);

        tipoRepository.save(tipo);

        Collection<Tipo> tiposRetornados = tipoRepository.findByNomeContaining(nomeEsperado);

        assertTrue(tiposRetornados.contains(tipo));
    }

    @Test
    public void deve_remover_pelo_nome(){
        String fada = "Fada";
        String fantasma = "Fantasma";

        tipoRepository.save(new Tipo(fada));
        tipoRepository.save(new Tipo(fantasma));

        String  termo = "Fa";
        Long quantidadeEsperada = 2l;

        Long quantidadeRemovida = tipoRepository.deleteByNomeContaining(termo);

        assertEquals(quantidadeEsperada, quantidadeRemovida);
    }
}
