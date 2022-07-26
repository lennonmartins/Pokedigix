package br.com.digix.pokedigix.pokemon;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.ManyToAny;

import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.tipo.Tipo;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   
    @Column(nullable = false, length = 20)
    private String nome;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Genero genero;
    
    @Column(nullable = false)
    private int nivel;
    
    @Column(nullable = false)
    private int felicidade;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="POKEMON_TIPO",
             joinColumns={@JoinColumn(name="POKEMON_ID")},
             inverseJoinColumns={@JoinColumn(name="TIPO_ID")})
    private Collection <Tipo> tipos;
    
    @Column(nullable = false)
    private double altura;

    @Column(nullable = false)
    private double peso;

    @Column(nullable = false)
    private int numeroPokedex;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "POKEMON_ATAQUE",
        joinColumns = @JoinColumn(name = "POKEMON_ID"),
        inverseJoinColumns = @JoinColumn(name = "ATAQUE_ID")
    )
    private Collection<Ataque> ataques;
    
    
    public Pokemon(String nome, int nivel, int felicidade,  double altura, double peso, int numeroPokedex, Genero genero, Collection<Tipo> tipos, Collection<Ataque> ataques ) throws LimiteDeNivelException, FelicidadePokemonInvalidaException {

        validarNivel(nivel);
        validarFelicidade(felicidade);
        this.nome = nome;
        this.nivel = nivel;
        this.felicidade = felicidade;
        this.altura = altura;
        this.peso = peso;
        this.numeroPokedex = numeroPokedex;
        this.genero = genero;
        this.tipos = tipos;
        this.ataques = ataques;
        
    }
    
    private void validarNivel(int nivel) throws LimiteDeNivelException {
        if(nivel<1 || nivel > 100){
            throw new LimiteDeNivelException();
        }
    }

    private void validarFelicidade(int felicidade) throws FelicidadePokemonInvalidaException {
        if(felicidade< 0 || felicidade > 100){
           throw new FelicidadePokemonInvalidaException(felicidade);
        }
    }

    public Collection<Ataque> getAtaques() {
        return ataques;
    }
    public Genero getGenero() {
        return genero;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return this.nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public double getAltura() {
        return this.altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return this.peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
   
    public int getNumeroPokedex() {
        return this.numeroPokedex;
    }
    public void setNumeroPokedex(int numeroPokedex) {
        this.numeroPokedex = numeroPokedex;
    }

    public int getFelicidade() {
        return this.felicidade;
    }
    public void setFelicidade(int felicidade) {
        this.felicidade = felicidade;
    }
	public Long getId() {
		return this.id;
	}

    public Collection<Tipo> getTipos() {
        return tipos;
    }

}
