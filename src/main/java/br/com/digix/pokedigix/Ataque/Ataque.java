package br.com.digix.pokedigix.ataque;

import br.com.digix.pokedigix.tipo.Tipo;

public class Ataque {
   private String nome;
   private String forca;
   private double acuracia;
   private int pontosDePoder;
   private Categoria categoria;
   private String descricao;
   private Tipo tipoAtaque;

   public Ataque(String nome, String forca, double acuracia, int pontosDePoder, String categoria, String descricao) {
      this.nome = nome;
      this.forca = forca;
      this.acuracia = acuracia;
      this.pontosDePoder = pontosDePoder;
      this.descricao = descricao;
   }

   public String getNome() {
      return nome;
   }
   public void setNome(String nome) {
      this.nome = nome;
   }
   public String getForca() {
      return forca;
   }
   public void setForca(String forca) {
      this.forca = forca;
   }
   public double getAcuracia() {
      return acuracia;
   }
   public void setAcuracia(double acuracia) {
      this.acuracia = acuracia;
   }
   public int getPontosDePoder() {
      return pontosDePoder;
   }
   public void setPontosDePoder(int pontosDePoder) {
      this.pontosDePoder = pontosDePoder;
   }
   public String getDescricao() {
      return descricao;
   }
   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }
   


   


}
