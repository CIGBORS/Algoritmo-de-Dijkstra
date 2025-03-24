public class Listap {
    private Nodep inicio;

    public Listap (){
        this.inicio = null;
    }

    public void add(int linha, int coluna, int distancia){
        if(inicio != null){
            inicio.push(linha, coluna, distancia);
        }
        else{
            inicio = new Nodep(linha, coluna, distancia);
        }
    }

    // public int[] pmin(int partida,int p[]){
    //     Integer[] menor = {null,null,null};
    //     return inicio.pmin(partida,p, menor);
    // }

    public  void show(){
        if(inicio != null){
            inicio.show();
        }
        else{
            System.out.println("Lista Vazia");
        }
    }
}
