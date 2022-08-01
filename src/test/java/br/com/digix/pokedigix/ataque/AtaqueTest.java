package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import br.com.digix.pokedigix.tipo.Tipo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AtaqueTest {
    @Test
    void deve_criar_um_ataque()throws Exception{
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
    public void deve_ser_obrigatorio_informar_um_tipo() throws Exception{
        Tipo tipoEsperado = new  Tipo("Psíquico");
        
        Ataque ataque = new AtaqueBuilder().comTipo(tipoEsperado).construir();

        assertEquals(tipoEsperado, ataque.getTipo());
    }

    @Test
    public void deve_ser_obrigatorio_informar_um_tipo_para_novo_ataque() throws Exception{
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

    @Test
    public void deve_ter_acuracia_menor_que_zero() throws Exception{
        //Arrange
        String nomeEsperado = "Confusão";
        int forcaEsperada = 95;
        double acuraciaEsperada = -1;
        int pontosDePoderEsperado = 35;
        String descricaoEsperada = "Causa confusão no oponente";
        Categoria categoriaEsperada = Categoria.ESPECIAL;
        Tipo tipoEsperado = new  Tipo("Psíquico");
      

        //Arrange
        Assertions.assertThrows(AcuraciaInvalidaException.class, () -> {
            new Ataque(nomeEsperado, forcaEsperada, acuraciaEsperada, pontosDePoderEsperado, descricaoEsperada, categoriaEsperada, tipoEsperado);
        });

    }

    @Test
    public void nao_deve_ter_acuracia_menor_que_zero() throws Exception{
        //Arrange 
        int acuracia = -1;

        //Assert
        assertThrows(AcuraciaInvalidaException.class, () ->{
            //Action
            new AtaqueBuilder().comAcuracia(acuracia).construir();
        } );
        assertThrows(AcuraciaInvalidaException.class, () ->{
            //Action
            new AtaqueBuilder().comCategoriaEfeito().comAcuracia(acuracia).construir();
        } );
             
    }

    @Test public void nao_deve_ter_acuracia_maior_que_cem() throws Exception{
        int acuracia = 101;

        //Assert
        assertThrows(AcuraciaInvalidaException.class, () ->{
            //Action
            new AtaqueBuilder().comAcuracia(acuracia).construir();
        } );

        assertThrows(AcuraciaInvalidaException.class, () ->{
            //Action
            new AtaqueBuilder().comCategoriaEfeito().comAcuracia(acuracia).construir();
        } );
    }

    @Test
    public void deve_poder_ter_acuracia_igual_a_zero() throws Exception{
        int acuraciaEsperada = 0;

        Ataque ataque = new AtaqueBuilder().comAcuracia(acuraciaEsperada).construir();

        assertEquals(acuraciaEsperada, ataque.getAcuracia());
    }

    @Test
    public void nao_deve_ter_forca_nem_tipo_quando_categoria_efeito() throws Exception {
        Categoria categoria = Categoria.EFEITO;
        int forca = 0;
        Tipo tipo = null;

        Ataque ataque = new AtaqueBuilder().comCategoriaEfeito().construir();

        assertEquals(categoria, ataque.getCategoria());
        assertEquals(forca, ataque.getForca());
        assertEquals(tipo, ataque.getTipo());
    }

    @Test
    public void nao_deve_criar_ataque_fisico_sem_forca() throws Exception{
        Categoria categoria = Categoria.FISICO;
        int forca = 0;

        assertThrows(ForcaInvalidaParaCategoriaException.class, () ->{new AtaqueBuilder().comForca(forca).comCategoria(categoria).construir(); });
    }
    
    @Test
    public void nao_deve_criar_ataque_fisico_sem_tipo() throws Exception{
        Categoria categoria = Categoria.FISICO;
        Tipo tipo = null;

        assertThrows(TipoInvalidoParaCategoriaException.class, () ->{new AtaqueBuilder().comTipo(tipo).comCategoria(categoria).construir(); });
    }

    @Test
    public void nao_deve_criar_ataque_especial_sem_forca() throws Exception{
        Categoria categoria = Categoria.ESPECIAL;
        int forca = 0;

        assertThrows(ForcaInvalidaParaCategoriaException.class, () ->{new AtaqueBuilder().comForca(forca).comCategoria(categoria).construir(); });
    }
    
    @Test
    public void nao_deve_criar_ataque_especial_sem_tipo() throws Exception{
        Categoria categoria = Categoria.ESPECIAL;
        Tipo tipo = null;

        assertThrows(TipoInvalidoParaCategoriaException.class, () ->{new AtaqueBuilder().comTipo(tipo).comCategoria(categoria).construir(); });
    }

   
}
