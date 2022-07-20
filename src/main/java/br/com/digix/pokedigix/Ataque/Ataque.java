package br.com.digix.pokedigix.ataque;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
   //private Tipo tipoAtaque;

   public Ataque(String nome, int forca, double acuracia, int pontosDePoder, String descricao, Categoria categoria) {
      this.nome = nome;
      this.forca = forca;
      this.acuracia = acuracia;
      this.pontosDePoder = pontosDePoder;
      this.descricao = descricao;
      this.categoria = categoria;
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
   public void setAcuracia(double acuracia) {
      this.acuracia = acuracia;
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


   


}
