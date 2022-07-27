package br.com.digix.pokedigix.pokemon;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.digix.pokedigix.tipo.Tipo;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
    

}
