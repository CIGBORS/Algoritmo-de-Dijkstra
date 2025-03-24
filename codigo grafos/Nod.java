public class Node{
    // variáveis de instância
    private int x;
    private Node prox;

    /**
     * Construtor para objetos da classe Node
     */
    public Node(int x)
    {
        // inicializa variáveis de instância
        this.x = x;
        this.prox = null;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setProx(Node prox){
        this.prox = prox;
    }
    
    public int getX(){
        return this.x;
    }
    
    public Node getProx(){
        return this.prox;
    }

    
}
