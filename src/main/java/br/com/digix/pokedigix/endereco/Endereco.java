package br.com.digix.pokedigix.endereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 10)
    private String cidade;

    @Column(nullable = false, length = 25)
    private String regiao;
    
    public Endereco(String cidade, String regiao) {
        this.cidade = cidade;
        this.regiao = regiao;
    }

    public String getCidade() {
        return this.cidade;
    }

    public String getRegiao() {
        return this.regiao;
    }
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
}
