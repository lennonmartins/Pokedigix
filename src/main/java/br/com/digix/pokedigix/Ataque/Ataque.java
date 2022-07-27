package br.com.digix.pokedigix.ataque;

import java.util.Collection;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.digix.pokedigix.ataque.AcuraciaExcepetion;
import br.com.digix.pokedigix.pokemon.Pokemon;
import br.com.digix.pokedigix.tipo.Tipo;
@Entity
public class Ataque {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Column(nullable = false, length = 25)
   private String nome;
   
   private int forca;
   
   @Column(nullable = false)
   private double acuracia;
   
   @Column(nullable = false)
   private int pontosDePoder;
   
   @Enumerated(EnumType.STRING)
   @Column(nullable = false, length = 25)
   private Categoria categoria;
   
   @Column(nullable = false)
   private String descricao;
   
   @ManyToOne
   private Tipo tipo;

   @ManyToMany(mappedBy = "ataques")
   private Collection<Pokemon> pokemons;

 
   public Ataque(String nome, int forca, double acuracia, int pontosDePoder, String descricao, Categoria categoria, Tipo tipo) {
      this.nome = nome;
      this.forca = forca;
      this.acuracia = acuracia;
      this.pontosDePoder = pontosDePoder;
      this.descricao = descricao;
      this.categoria = categoria;
      this.tipo = tipo;
   }
 
   public Tipo getTipo() {
      return tipo;
   }

   public String getNome() {
      return this.nome;
   }
   public void setNome(String nome) {
      this.nome = nome;
   }
   public int getForca() {
      return this.forca;
   }
   public void setForca(int forca) {
      this.forca = forca;
   }
   public double getAcuracia() {
      return this.acuracia;
   }
   public void setAcuracia(double acuracia) throws AcuraciaExcepetion {
      if (acuracia > 0 && acuracia <100) {
         this.acuracia = acuracia;
      }else{
         throw new AcuraciaExcepetion();
       }  
   }

   public int getPontosDePoder() {
      return this.pontosDePoder;
   }
   public void setPontosDePoder(int pontosDePoder) {
      this.pontosDePoder = pontosDePoder;
   }
   public String getDescricao() {
      return this.descricao;
   }
   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }

   public Long getId() {
      return this.id;
   }
   
   public Categoria getCategoria() {
       return categoria;
   }

   public Collection<Pokemon> getPokemons() {
      return pokemons;
   }   


}
