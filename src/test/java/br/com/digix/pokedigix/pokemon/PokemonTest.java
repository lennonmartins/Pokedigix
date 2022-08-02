package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestExecutionListeners;

import br.com.digix.pokedigix.tipo.Tipo;

public class PokemonTest {
    
    @Test
    public void deve_adicionar_um_pokemon() throws Exception{
        String nomeEsperado = "Ralts";
        int nivelEsperado = 11;
        int felicidadeEsperada = 25;
        double alturaEsperado = 0.40;
        double pesoEsperado = 7.0;
        int numeroPokedexEsperado = 281;
        Genero generoEsperado = Genero.F;
        List <Tipo> tiposEsperados = new ArrayList<>();
        tiposEsperados.add(new Tipo("Psíquico"));

        Pokemon pokemon = new PokemonBuilder().construir();


        assertEquals(nomeEsperado, pokemon.getNome());
        assertEquals(nivelEsperado, pokemon.getNivel());
        assertEquals(felicidadeEsperada, pokemon.getFelicidade());
        assertEquals(alturaEsperado, pokemon.getAltura());
        assertEquals(pesoEsperado, pokemon.getPeso());
        assertEquals(numeroPokedexEsperado, pokemon.getNumeroPokedex());
        assertEquals(generoEsperado, pokemon.getGenero());

    }

    @Test
    public void deve_cadastrar_um_tipo_para_o_pokemon() throws Exception{
        Tipo tipo = new Tipo("Fada");

        Pokemon pokemon = new PokemonBuilder().comTipo(tipo).construir();


        assertTrue(pokemon.getTipos().contains(tipo));
    }

   @Test
   public void deve_ter_nivel_minimo_um() throws Exception{
        int nivelMinimo = 1;
    
        Pokemon pokemon = new PokemonBuilder().comNivel(nivelMinimo).construir();

        assertEquals(nivelMinimo, pokemon.getNivel());
   }

   @Test
   public void deve_ter_nivel_maximo_cem() throws Exception{
    int nivelMaximo = 100;
    
    Pokemon pokemon = new PokemonBuilder().comNivel(nivelMaximo).construir();

    assertEquals(nivelMaximo, pokemon.getNivel());
   }

   @Test
   public void nao_deve_ter_nivel_maior_que_cem(){
    int nivel = 101;

    assertThrows(LimiteDeNivelException.class, () -> new PokemonBuilder().comNivel(nivel).construir());
   }

   @Test
   public void nao_deve_ter_nivel_menor_que_um(){
    int nivel = 0;

    assertThrows(LimiteDeNivelException.class, () -> new PokemonBuilder().comNivel(nivel).construir());
   }

   @Test
   public void deve_ter_felicidade_minima_zero() throws Exception{
    int felicidadeMinima = 0;

    Pokemon pokemon = new PokemonBuilder().comFelicidade(felicidadeMinima).construir();

    assertEquals(felicidadeMinima,pokemon.getFelicidade());
   }

   @Test
   public void deve_ter_felicidade_maxima_cem() throws Exception{
    int felicidadeMaxima = 100;

    Pokemon pokemon = new PokemonBuilder().comFelicidade(felicidadeMaxima).construir();

    assertEquals(felicidadeMaxima,pokemon.getFelicidade());
   }

   @Test
   public void nao_deve_ter_felicidade_menor_que_zero() throws Exception{
    int felicidadeInvalida = -1;

    assertThrows(FelicidadePokemonInvalidaException.class, () -> new PokemonBuilder().comFelicidade(felicidadeInvalida).construir());
    
   }

   @Test
   public void nao_deve_ter_felicidade_maior_que_cem() throws Exception{
    int felicidadeInvalida = 101;

    assertThrows(FelicidadePokemonInvalidaException.class, () -> new PokemonBuilder().comFelicidade(felicidadeInvalida).construir());
    
   }

   
}
