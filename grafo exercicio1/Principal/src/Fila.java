public class Fila{
  private int[] vetor;
  private int fim;

  public Fila(int tam){
    vetor = new int[tam];
    fim = -1;
  }

  public void push(int valor){
    if(fim == vetor.length-1)
      System.out.println("Fila Cheia!");
    else{
      fim++;
      vetor[fim]=valor;
    }
  }

  public int pop(){
    int aux = vetor[0];
    if(fim>=0){
      for(int i=0; i<fim; i++)
        vetor[i] = vetor[i+1];
      fim--;
      return aux;
    } else{
      System.out.println("Fila Vazia!");
      return -99999;
    }
  }

  public boolean isFull(){
    return (fim == vetor.length-1);
  }

  public boolean isEmpty(){
    return (fim == -1);
  }
}
