package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import br.com.digix.pokedigix.ataque.AcuraciaExcepetion;
import br.com.digix.pokedigix.tipo.Tipo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AtaqueTest {
    @Test
    void deve_criar_um_ataque(){
        //Arrange
        String nomeEsperado = "Confusão";
        int forcaEsperada = 95;
        double acuraciaEsperada = 100;
        int pontosDePoderEsperado = 35;
        String descricaoEsperada = "Causa confusão no oponente";
        Categoria categoriaEsperada = Categoria.ESPECIAL;
        Tipo tipoEsperado = new  Tipo("Psíquico");

        //Act
        Ataque ataque = new AtaqueBuilder().construir();

        //Arrange
        assertEquals(nomeEsperado, ataque.getNome());
        assertEquals(forcaEsperada, ataque.getForca());
        assertEquals(acuraciaEsperada, ataque.getAcuracia());
        assertEquals(pontosDePoderEsperado, ataque.getPontosDePoder());
        assertEquals(descricaoEsperada, ataque.getDescricao());

    }

    @Test
    public void deve_verificar_uma_acuracia_fora_da_condicao() throws Exception{
        //Arrange
        String nomeEsperado = "Confusão";
        int forcaEsperada = 95;
        double acuraciaEsperada = 110;
        int pontosDePoderEsperado = 35;
        String descricaoEsperada = "Causa confusão no oponente";
        Categoria categoriaEsperada = Categoria.ESPECIAL;
        Tipo tipoEsperado = new  Tipo("Psíquico");
      

        //Arrange
        Assertions.assertThrows(AcuraciaExcepetion.class, () -> {
            new Ataque(nomeEsperado, forcaEsperada, acuraciaEsperada, pontosDePoderEsperado, descricaoEsperada, categoriaEsperada, tipoEsperado);
        });

    }

    @Test
    public void deve_ser_obrigatorio_informar_um_tipo(){
        Tipo tipoEsperado = new  Tipo("Psíquico");
        
        Ataque ataque = new AtaqueBuilder().comTipo(tipoEsperado).construir();

        assertEquals(tipoEsperado, ataque.getTipo());
    }

    @Test
    public void deve_ser_obrigatorio_informar_um_tipo_para_novo_ataque(){
        String nomeEsperado = "Beijo Drenante";
        int forcaEsperada = 50;
        double acuraciaEsperada = 100;
        int pontosDePoderEsperado = 10;
        String descricaoEsperada = "O usuário rouba o HP do alvo com um beijo. O HP do usuário é restaurado em mais da metade do dano recebido pelo alvo.";
        Categoria categoriaEsperada = Categoria.ESPECIAL;
        Tipo tipoEsperado = new  Tipo("Fada");
        
        Ataque ataque = new Ataque(nomeEsperado, forcaEsperada, acuraciaEsperada, pontosDePoderEsperado, descricaoEsperada, categoriaEsperada, tipoEsperado);

        assertEquals(tipoEsperado, ataque.getTipo());
    }
}
