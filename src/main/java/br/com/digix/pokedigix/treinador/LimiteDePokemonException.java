package br.com.digix.pokedigix.treinador;

public class LimiteDePokemonException extends Exception{

    public LimiteDePokemonException() {
        super(
            "Um treinador não pode ter mais do que 6 pokemóns simultaneamente."
        );
    }
    
}
