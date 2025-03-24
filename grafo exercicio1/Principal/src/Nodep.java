public class Nodep {
    private int linha;
    private int coluna;
    private int distancia;
    private Nodep proximo;

    public Nodep(int linha, int coluna,int distancia){
        this.linha = linha;
        this.coluna = coluna;
        this.distancia = distancia;
        this.proximo = null;
    }

    public int getLinha() {
        return this.linha;
    }

    public void setLinha(int linha){
        this.linha = linha;
    }

    public void setProximo(Nodep proximo){
        this.proximo=proximo;
    }

    public void setColuna(int coluna) {
        this.coluna=coluna;
    }

    public int getColuna() {
        return this.coluna;
    }

    public void setDistancia(int distancia) {
        this.distancia=distancia;
    }

    public int getDistancia(){
        return this.distancia;
    }

    public Nodep getProximo(){
        return this.proximo;
    }

    public void show(){
        System.out.println("vertice: " + linha + " " + coluna + " " + distancia);
        if (proximo!= null){
            proximo.show();
        }
    }
}