package br.com.digix.pokedigix.ataque;

import br.com.digix.pokedigix.tipo.Tipo;

public class AtaqueBuilder {

    private String nome;
    private int forca;
    private int acuracia;
    private int pontosDePoder;
    private String descricao;
    private Categoria categoria;
    private Tipo tipo;
    private Tipo tipoEsperado;

    public AtaqueBuilder(){
        this.nome = "Confusão";
        this.forca = 95;
        this.acuracia = 100;
        this.pontosDePoder = 35;
        this.descricao = "Causa confusão no oponente";
        this.categoria = Categoria.ESPECIAL;
        this.tipo = new  Tipo("Psíquico");
    }

    public Ataque construir() {
        return new Ataque(nome, forca, acuracia, pontosDePoder, descricao, categoria, tipo);
    }

    public AtaqueBuilder comTipo(Tipo tipoEsperado) {
        this.tipo = tipoEsperado;
        return this;
    }
    
}
