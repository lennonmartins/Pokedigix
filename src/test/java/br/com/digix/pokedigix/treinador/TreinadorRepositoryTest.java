package br.com.digix.pokedigix.treinador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class TreinadorRepositoryTest {
    
    @Autowired
    private TreinadorRepository treinadorRepository;

    @Test
    public void deve_salvar_um_treinador(){
        String nomeEsperado = "Francisco Roberto";
        double dinheiroEsperado = 200;
        int nivelEsperado = 0;
        int quantidadePokemonEsperado = 0;
        Long idEsperado = 1L;

        Treinador treinador = new Treinador(nomeEsperado, dinheiroEsperado, nivelEsperado, quantidadePokemonEsperado);
        treinadorRepository.save(treinador);

        assertEquals(idEsperado, treinador.getId());
        
    }
}
