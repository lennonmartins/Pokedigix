package br.com.digix.pokedigix.lider;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Lider {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 25)
    private String nome;

    @Column(nullable = false)
    private int nivel;

    @Column(nullable = false)
    private Insignia insignia;
   
    public Lider(String nome, int nivel, Insignia insignia) {
        this.nome = nome;
        this.nivel = nivel;
        this.insignia = insignia;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Insignia getInsignia() {
        return this.insignia;
    }

    public Long getId() {
        return this.id;
    }

}
