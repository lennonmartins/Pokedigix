package br.com.digix.pokedigix.ataque;

import br.com.digix.pokedigix.tipo.Tipo;
import br.com.digix.pokedigix.tipo.TipoResponseDTO;

public class AtaqueResponseDTO {

    private Long id;
    private String nome;
    private int forca;
    private double acuracia;
    private int pontosDePoder;
    private String descricao;
    private Categoria categoria;
    private TipoResponseDTO tipo;
    
    
    
    public AtaqueResponseDTO(Long id, String nome, int forca, double acuracia, int pontosDePoder, String descricao, Categoria categoria, TipoResponseDTO tipo) {
        this.id = id;
        this.nome = nome;
        this.forca = forca;
        this.acuracia = acuracia;
        this.pontosDePoder = pontosDePoder;
        this.descricao = descricao;
        this.categoria = categoria;
        this.tipo = tipo;
        
    }
    
    public TipoResponseDTO getTipo() {
        return tipo;
    }

    public void setTipo(TipoResponseDTO tipo) {
        this.tipo = tipo;
    }
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
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
