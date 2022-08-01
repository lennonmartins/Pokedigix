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

    public AtaqueBuilder(){
        this.nome = "Confusão";
        this.forca = 95;
        this.acuracia = 100;
        this.pontosDePoder = 35;
        this.descricao = "Causa confusão no oponente";
        this.categoria = Categoria.ESPECIAL;
        this.tipo = new  Tipo("Psíquico");
    }

    
    public AtaqueBuilder comTipo(Tipo tipoEsperado) {
        this.tipo = tipoEsperado;
        return this;
    }
    
    public AtaqueBuilder comAcuracia(int acuracia) {
        this.acuracia = acuracia;
        return this;
    }
    
    public AtaqueBuilder comCategoriaEfeito() {
        this.categoria = Categoria.EFEITO;
        return this;
    }

    public AtaqueBuilder comForca(int forca) {
        this.forca = forca;
        return this;
    }

    public Ataque construir() throws Exception {
        if(this.categoria.equals(Categoria.EFEITO)){
           return new Ataque(nome,acuracia, pontosDePoder, descricao);
        } else{
            return new Ataque(nome, forca, acuracia, pontosDePoder, descricao, categoria, tipo);
        }
    }


    public AtaqueBuilder comCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }





    
}
