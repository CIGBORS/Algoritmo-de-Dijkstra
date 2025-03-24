public class FilaPrioridade{
  private int N;
  private int v[];
  private int fim;

  public FilaPrioridade(int tam){
      N = tam;
      v = new int[tam];
      fim = -1;
  }

  public void ordena(int [] D){
    int temp;
    // bubble sort
    for(int i=1; i<fim; i++){
      for(int j=0; j<fim; j++){
        if(D[v[j]] > D[v[j+1]]){
          temp = v[j];
          v[j] = v[j+1];
          v[j+1] = temp;
        }
      }
    }
  }

  public void push(int vt, int [] D){
    if((fim+1) < N){
        fim++;
        v[fim] = vt;
        ordena(D);
    }
    else
      System.out.println("FilaPrioridade::push => Tentativa de insercao em Fila Cheia!");
  }

  public int pop(){
    int valor;
    if(fim>-1){
      valor = v[0];
      for(int i=0; i<fim; i++){
        v[i] = v[i+1];
      }
      fim--;
    }
    else{
      System.out.println("FilaPrioridade::pop => Tentativa de remocao em Fila Vazia!");
      valor = -999999;
    }
    return valor;
  }

  public boolean isEmpty(){
    if(fim>-1) return false;
    else return true;
  }

  public boolean isFull(){
    if(fim<N-1) return false;
    else return true;
  }
}
