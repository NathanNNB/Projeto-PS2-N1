package mack.br.projeton1.entidades;

public class Jogo {

    private String idjogo;
    private String nomeA;
    private String nomeB;
    private int golsA;
    private int golsB;

    public Jogo(){}

    public Jogo(String idjogo,String nomeA, String nomeB, int golsA, int golsB){
        this.idjogo = idjogo;
        this.nomeA = nomeA;
        this.nomeB = nomeB;
        this.golsA = golsA;
        this.golsB = golsB;
    }

    public String getIdjogo() {
        return idjogo;
    }

    public void setIdjogo(String idjogo) {
        this.idjogo = idjogo;
    }

    public String getNomeA() {
        return nomeA;
    }

    public void setNomeA(String nomeA) {
        this.nomeA = nomeA;
    }

    public String getNomeB() {
        return nomeB;
    }

    public void setNomeB(String nomeB) {
        this.nomeB = nomeB;
    }

    public int getGolsA() {
        return golsA;
    }

    public void setGolsA(int golsA) {
        this.golsA = golsA;
    }

    public int getGolsB() {
        return golsB;
    }

    public void setGolsB(int golsB) {
        this.golsB = golsB;
    }

    @Override
    public String toString(){
        return "[idJogo: "+idjogo+
                ", nome do time A: "+nomeA+
                ", nome do time B: "+nomeB+
                ", gols do time A: "+golsA+
                ", gols do time B: "+golsB+"]";
    }
}
