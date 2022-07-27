package br.com.digix.pokedigix.endereco;

public class EnderecoBuilder {

    private  String regiao;
    private String cidade;

    public EnderecoBuilder() {
        this.regiao = "Hoenn";
        this.cidade = "Petallburg City";
    }

    public Endereco construir() {
        return new  Endereco(cidade, regiao);
    }

   

}
