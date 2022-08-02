package br.com.digix.pokedigix.pokemon;

public class FelicidadePokemonInvalidaException extends Exception{

    public FelicidadePokemonInvalidaException(int felicidade) {
        super("A felicidade " + felicidade + " é inválida. O valor deve ser entre 0 a 100");
    }
    
}
