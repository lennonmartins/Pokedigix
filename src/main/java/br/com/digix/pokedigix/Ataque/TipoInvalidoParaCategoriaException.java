package br.com.digix.pokedigix.ataque;

import br.com.digix.pokedigix.tipo.Tipo;

public class TipoInvalidoParaCategoriaException extends Exception{

    public TipoInvalidoParaCategoriaException( Categoria categoria) {
        super("A categoria " + categoria.name() + " deve ter um tipo.");
    }
    
    
}
