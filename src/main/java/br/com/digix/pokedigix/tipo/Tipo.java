package br.com.digix.pokedigix.tipo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;

    //construtor;
    public Tipo(String nomeEsperado) {
        this.nome = nomeEsperado;
    }

    public Object getNome() {
        return this.nome;
    }
    
    public void setId(Long id) {
            this.id = id;
    }

    public Long getId() {
        return this.id;
    }


}
