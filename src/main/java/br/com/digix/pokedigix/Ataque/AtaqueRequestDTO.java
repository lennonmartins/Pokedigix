package br.com.digix.pokedigix.ataque;

public class AtaqueRequestDTO {
    private String nome;
    private int forca;
    private double acuracia;
    private int pontosDePoder;
    private String descricao;
    private Categoria categoria;
    private Long TipoId;
        
    public AtaqueRequestDTO(String nome, int forca, double acuracia, int pontosDePoder, String descricao,
            Categoria categoria, Long tipoId) {
        this.nome = nome;
        this.forca = forca;
        this.acuracia = acuracia;
        this.pontosDePoder = pontosDePoder;
        this.descricao = descricao;
        this.categoria = categoria;
        TipoId = tipoId;
    }

    public Long getTipoId() {
        return TipoId;
    }
    public void setTipoId(Long tipoId) {
        TipoId = tipoId;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
