package br.com.digix.pokedigix.pokemon;

public class LimiteDeNivelException extends Exception{

    public LimiteDeNivelException() {
        super("O nivel não pode ser menor que 1 e maior que 100");
    }
    
}
