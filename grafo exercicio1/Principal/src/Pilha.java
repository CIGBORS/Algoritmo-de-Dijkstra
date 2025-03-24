public class Pilha{
    private Nodep topo;

    public Pilha(){
        topo = null;
    }

    public void push(int linha, int coluna,int distancia){
        if(topo==null){
            topo = new Nodep(linha, coluna, distancia);
        }
        else{
            Nodep novo = new Nodep(linha, coluna, distancia);
            novo.setProximo(topo);
            topo = novo;
        }
    }

    public void show(){
        if(topo != null){
            topo.show();
        }
        else{
            System.out.println("BAGUIO TÁ VAZIO DESGRAÇA");
        }
    }

    public int pop(){
        Nodep aux = topo;
        if(aux==null){
            System.out.println("Tentativa de remover em pilha vazia");
            return -99999;
        }
        else{
            topo = topo.getProximo();
            return aux.getLinha();
        }
    }

    public boolean isEmpty(){
        if(topo == null) return true;
        else return false;
    }
}