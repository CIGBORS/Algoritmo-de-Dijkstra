public class Pilha{
    Node topo;
    /**
     * Construtor para objetos da classe Pilha
     */
    public Pilha(){
        topo = null;
    }

    public void push(int x){
        if(topo==null){
            topo = new Node(x);
        }
        else{
            Node novo = new Node(x);
            novo.setProx(topo);
            topo = novo;
        }
        
    }
    
    public int pop(){
        Node aux = topo;
        if(aux==null){
            System.out.println("Tentativa de remover em pilha vazia");
            return -99999;
        }
        else{
            topo = topo.getProx();
            return aux.getX();
        }
    }
    
    public boolean isEmpty(){
        if(topo==null) return true;
        else return false;
    }
}
