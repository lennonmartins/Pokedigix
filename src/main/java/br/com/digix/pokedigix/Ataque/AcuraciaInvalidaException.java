package br.com.digix.pokedigix.ataque;

public class AcuraciaInvalidaException extends Exception {

    public AcuraciaInvalidaException() {
        super("A acurácia deve estar entre 0 e 100, considerando os extremos.");
    }
    
}
