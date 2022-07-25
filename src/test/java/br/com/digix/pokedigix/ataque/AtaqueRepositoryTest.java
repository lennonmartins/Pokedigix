package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokedigix.tipo.Tipo;
import br.com.digix.pokedigix.tipo.TipoRepository;

@DataJpaTest
public class AtaqueRepositoryTest {
    
    @Autowired
    private AtaqueRepository ataqueRepository;

    @Autowired
    private TipoRepository tipoRepository;

    @Test
    public void deve_salvar_um_ataque(){
        //Arrange
        String nomeEsperado = "Confusão";
        int forcaEsperada = 95;
        double acuraciaEsperada = 100;
        int pontosDePoderEsperado = 35;
        String descricaoEsperada = "Causa confusão no oponente";
        Categoria categoriaEsperada = Categoria.ESPECIAL;
        Tipo tipoEsperado = new Tipo("Psíquico");

        //Act
        Ataque ataque = new Ataque(nomeEsperado, forcaEsperada, acuraciaEsperada, pontosDePoderEsperado, descricaoEsperada, categoriaEsperada, tipoEsperado);
        ataqueRepository.save(ataque);

        //Assert
        assertNotNull(ataque.getId());        
    }

    @Test
    public void deve_salvar_um_tipo_para_um_ataque(){
        String nomeEsperado = "Confusão";
        int forcaEsperada = 95;
        double acuraciaEsperada = 100;
        int pontosDePoderEsperado = 35;
        String descricaoEsperada = "Causa confusão no oponente";
        Categoria categoriaEsperada = Categoria.ESPECIAL;
        Tipo tipoEsperado = new Tipo("Psíquico");

        Ataque ataque = new Ataque(nomeEsperado, forcaEsperada, acuraciaEsperada, pontosDePoderEsperado, descricaoEsperada, categoriaEsperada, tipoEsperado);
        
        tipoRepository.save(tipoEsperado);
        ataqueRepository.save(ataque);


        Ataque ataqueRetornado = ataqueRepository.findById(ataque.getId()).get();
       
        assertEquals(tipoEsperado.getNome(), ataqueRetornado.getTipo().getNome());
        assertEquals(ataque.getTipo().getId(), ataqueRetornado.getTipo().getId());
        assertNotNull(ataqueRetornado.getTipo().getId());
    }

    @Test
    public void deve_buscar_um_ataque_pelo_seu_tipo(){
        String nomeEsperado = "Confusão";
        int forcaEsperada = 95;
        double acuraciaEsperada = 100;
        int pontosDePoderEsperado = 35;
        String descricaoEsperada = "Causa confusão no oponente";
        Categoria categoriaEsperada = Categoria.ESPECIAL;
        Tipo tipoEsperado = new Tipo("Psíquico");

        Ataque ataque = new Ataque(nomeEsperado, forcaEsperada, acuraciaEsperada, pontosDePoderEsperado, descricaoEsperada, categoriaEsperada, tipoEsperado);
        
        tipoRepository.save(tipoEsperado);
        ataqueRepository.save(ataque);


        Collection <Ataque> ataquesRetornados = ataqueRepository.findByTipo(tipoEsperado);
       
       assertTrue(ataquesRetornados.contains(ataque));
    }

    @Test
    public void deve_buscar_um_ataque_pelo_sua_categoria(){
        String nomeEsperado = "Confusão";
        int forcaEsperada = 95;
        double acuraciaEsperada = 100;
        int pontosDePoderEsperado = 35;
        String descricaoEsperada = "Causa confusão no oponente";
        Categoria categoriaEsperada = Categoria.ESPECIAL;
        Tipo tipoEsperado = new Tipo("Psíquico");

        Ataque ataque = new Ataque(nomeEsperado, forcaEsperada, acuraciaEsperada, pontosDePoderEsperado, descricaoEsperada, categoriaEsperada, tipoEsperado);
        
        tipoRepository.save(tipoEsperado);
        ataqueRepository.save(ataque);


        Collection <Ataque> ataquesRetornados = ataqueRepository.findByCategoria(categoriaEsperada);
       
       assertTrue(ataquesRetornados.contains(ataque));
       assertEquals(1, ataquesRetornados.size());
       assertNotNull(ataque.getTipo().getId());
    }

    @Test
    public void deve_verificar_se_o_tipo_do_ataque_nao_nulo(){
        String nomeEsperado = "Beijo Drenante";
        int forcaEsperada = 50;
        double acuraciaEsperada = 100;
        int pontosDePoderEsperado = 10;
        String descricaoEsperada = "O usuário rouba o HP do alvo com um beijo. O HP do usuário é restaurado em mais da metade do dano recebido pelo alvo.";
        Categoria categoriaEsperada = Categoria.ESPECIAL;
        Tipo tipoEsperado = new  Tipo("Fada");
        
        Ataque ataque = new Ataque(nomeEsperado, forcaEsperada, acuraciaEsperada, pontosDePoderEsperado, descricaoEsperada, categoriaEsperada, tipoEsperado);
        
        tipoRepository.save(tipoEsperado);
        ataqueRepository.save(ataque);

        Collection <Ataque> ataquesRetornados = ataqueRepository.findByCategoria(categoriaEsperada);
       
       assertTrue(ataquesRetornados.contains(ataque));
       assertEquals(1, ataquesRetornados.size());
       assertNotNull(ataque.getTipo().getId());
    }

}
