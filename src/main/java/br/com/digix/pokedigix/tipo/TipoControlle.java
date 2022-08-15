package br.com.digix.pokedigix.tipo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/api/v1/tipos"}, produces = {"application/json"})
public class TipoControlle {

    @Autowired
    private TipoRepository tipoRepository;

    @PostMapping(consumes = {"application/json"})
    public TipoResponseDTO criarTipo(@RequestBody  TipoRequestDTO novoTipo){
        Tipo tipo = new Tipo(novoTipo.getNome());
        tipoRepository.save(tipo);
        return new TipoResponseDTO(tipo.getId(), tipo.getNome());

    };

    @GetMapping()
    public Collection<TipoResponseDTO> buscarTodos(){
        Iterable<Tipo> tipos = tipoRepository.findAll();
        Collection<TipoResponseDTO> tipoRetornados = new ArrayList<>();    
        for(Tipo tipo : tipos){
            tipoRetornados.add(new TipoResponseDTO(tipo.getId(), tipo.getNome()));
        }
        return tipoRetornados;
    }

    
}
