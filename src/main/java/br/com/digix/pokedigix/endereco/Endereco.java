package br.com.digix.pokedigix.endereco;

public class Endereco {
    private String cidade;
    private String regiao;
    
    public Endereco(String cidade, String regiao) {
        this.cidade = cidade;
        this.regiao = regiao;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getRegiao() {
        return regiao;
    }
    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }
}
