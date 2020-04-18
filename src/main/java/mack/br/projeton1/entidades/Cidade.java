
package mack.br.projeton1.entidades;

public class Cidade {
    private String idCidade;
    private String nome;
    private String estado;
    private String pais;
    private String populacao;
    
    public Cidade(){}
    
    public Cidade(String idCidade,String nome,String estado,String pais,String populacao){
        this.idCidade = idCidade;
        this.nome = nome;
        this.estado = estado;
        this.pais = pais;
        this.populacao = populacao;
    
    }

    public String getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(String idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPopulacao() {
        return populacao;
    }

    public void setPopulacao(String populacao) {
        this.populacao = populacao;
    }

    @Override
    public String toString(){
        return "[idCidade: "+idCidade+
                ", nome: "+nome+
                ", estado: "+estado +
                ", pais: "+pais +
                ", população: "+populacao +"]";
    }

}
