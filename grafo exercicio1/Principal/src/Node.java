public class Node{
  private int vertice;
  private int peso;
  private Node next;

  public void setVertice(int v){
    vertice = v;
  }

  public int getVertice(){
    return vertice;
  }

  public void setPeso(int p){
    peso = p;
  }

  public int getPeso(){
    return peso;
  }

  public void setNext(Node n){
    next = n;
  }

  public Node getNext(){
    return next;
  }

  public Node(int v, int p){
    vertice = v;
    peso = p;
    next = null;
  }

  public void push(int v, int p){
    if(next==null)
      next = new Node(v, p);
    else
      next.push(v, p);
  }

  public void ImprimeGrafo(){
    System.out.print("[" + vertice + ", " + peso + "] - ");
    if(next!=null)
      next.ImprimeGrafo();
  }

  public boolean ExisteAresta(int v2){
      if(vertice == v2)
        return true;
      else
        if(next!=null)
          return next.ExisteAresta(v2);
        else
          return false;
  }
}
