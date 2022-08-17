package br.com.digix.pokedigix.tipo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(path = { "/api/v1/tipos" }, produces = { "application/json" })
public class TipoControlle {

    @Autowired
    private TipoRepository tipoRepository;

    @Operation(summary = "Criar um novo tipo que pode ser usado para Pokemons ou Ataques")
    @ApiResponse(responseCode = "201")
    @PostMapping(consumes = { "application/json" })
    public ResponseEntity<TipoResponseDTO> criarTipo(@RequestBody TipoRequestDTO novoTipo) {
        Tipo tipo = new Tipo(novoTipo.getNome());
        tipoRepository.save(tipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(new TipoResponseDTO(tipo.getId(), tipo.getNome()));

    };

    @Operation(summary = "Buscar todos os tipo cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista de tipos cadastrados ")
    @GetMapping()
    public ResponseEntity<Collection<TipoResponseDTO>> buscarTodos(
            @RequestParam(required = false, name = "termo") String nome) {
        Iterable<Tipo> tipos;
        if (nome != null) {
            tipos = tipoRepository.findByNomeContaining(nome);
        } else {
            tipos = tipoRepository.findAll();
        }

        Collection<TipoResponseDTO> tipoRetornados = new ArrayList<>();
        for (Tipo tipo : tipos) {
            tipoRetornados.add(new TipoResponseDTO(tipo.getId(), tipo.getNome()));
        }
        return ResponseEntity.ok(tipoRetornados);
    }

    @Operation(summary = "Buscar tipo pelo Id")
    @ApiResponse(responseCode = "200", description = "Tipo retornado pelo ID")
    @GetMapping(path = "/{id}")
    public ResponseEntity<TipoResponseDTO> buscarPorId(@PathVariable Long id) {
        Tipo tipo = tipoRepository.findById(id).get();
        return ResponseEntity.ok(new TipoResponseDTO(tipo.getId(), tipo.getNome()));
    }

    @Operation(summary = "Deleta tipo pelo ID informado")
    @ApiResponse(responseCode = "204")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletarTipoPorId(@PathVariable Long id) {
        tipoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Alterar o tipo cadastrado")
    @ApiResponse(responseCode = "200", description = "Altera o tipo cadastrado por ID")
    @PutMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<TipoResponseDTO> alterarTipo(@RequestBody TipoRequestDTO tipoRequestDTO,
            @PathVariable Long id) {
        Tipo tipoParaAlterar = tipoRepository.findById(id).get();
        tipoParaAlterar.setNome(tipoRequestDTO.getNome());
        tipoRepository.save(tipoParaAlterar);
        return ResponseEntity.ok(new TipoResponseDTO(tipoParaAlterar.getId(), tipoParaAlterar.getNome()));
    }

    @DeleteMapping()
    @Transactional
    public void deletarTipoPorNome(@RequestParam(required = true, name = "termo") String nome) {
        tipoRepository.deleteByNomeContaining(nome);
    }

}
