package br.com.digix.pokedigix.tipo;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import br.com.digix.pokedigix.pokemon.Pokemon;

public interface TipoRepository extends CrudRepository<Tipo, Long> {

    Collection<Tipo> findByNomeContaining(String nomeEsperado);

    Long deleteByNomeContaining(String nome);


}
