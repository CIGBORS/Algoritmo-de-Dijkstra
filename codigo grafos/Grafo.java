public class Grafo{
  private int N;  // quantidade de vertices
  private int M[][];  // matriz de adjacencia

  public Grafo(int N){
    this.N = N;
    M = new int[N][N];
  }

  public void InsereAresta(int v1, int v2, int peso, int direcionado){
    M[v1][v2] = peso;
    if (direcionado == 0) M[v2][v1] = peso;
  }

  public void ImprimeGrafo(){
    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++)
        System.out.print(M[i][j] + "  ");
      System.out.println();
    }
  }

    public boolean ExisteAresta(int v1, int v2){
      return (M[v1][v2]!=0);
    }

    public void RetiraAresta(int v1, int v2){
      int p = M[v1][v2];
      M[v1][v2] = 0;
      if(M[v2][v1] == p) M[v2][v1] = 0;

      /* Segunda versão
      if(M[v1][v2] == M[v2][v1]){
        M[v2][v1] = 0;
      }
      M[v1][v2] = 0;
      */
    }

    public void buscaProfundidade(int s){
      boolean[] visitados = new boolean[N];
      buscaProfundidadeRecursiva(s, visitados);
    }

    public void buscaProfundidadeRecursiva(int vertice, boolean [] visitados){
      visitados[vertice] = true;
      System.out.println("Visita: " + vertice);
      for(int i=0; i<N; i++){
        if(M[vertice][i]!=0 && !visitados[i])
          buscaProfundidadeRecursiva(i, visitados);
      }
    }

    public void buscaLargura(int s){
      Fila f = new Fila(N);
      int cor[] = new int[N];  // 0 = BRANCO, 1 = CINZA, 2 = PRETO
      int d[] = new int[N];    // distancia
      int pr[] = new int[N];   // precedente
      int u;

      for(int i=0; i<N; i++){
        cor[i] = 0;
        d[i] = +999999;  // infinito...
        pr[i] = -1; // nil
      }

      cor[s] = 1;
      d[s] = 0;
      pr[s] = -1;
      f.push(s);

      while(!f.isEmpty()){
        u = f.pop();
        for(int v=0; v<N; v++){
          if(M[u][v]!=0 && cor[v] == 0){
            cor[v] = 1;  // cinza
            d[v] = d[u] + M[u][v];
            pr[v] = u;
            f.push(v);
          }
        }
        cor[u] = 2; // preto
      }

      // debug
      for(int v=0; v<N; v++){
          System.out.println("vertice: " + v + " " + cor[v] + " " + d[v] + " " + pr[v]);
      }
    }

    // public void entregaspizza(Grafo e, int p[]){
    // int partida = 6;
    // int retorno= partida;
    // int[] pontomin = {};
    // Listap theway = new Listap();
    //   theway = e.Dijkstra(6,theway);
    //   pontomin = theway.pmin(partida,p);

    //   System.out.println("--------:"+"vertice"+ " custo"+ " caminho");
    //   theway.show();
    // for(int i = 0; i<p.length;i++) {

    // }

    // }
    public Listap Dijkstra(int s, Listap theway){
      int D[] = new int[N];
      int P[] = new int[N];
      int C[] = new int[N];
      FilaPrioridade Q = new FilaPrioridade(N);
      int u;

      D[s] = 0;
      P[s] = -1;

      for(int i=0; i<N; i++)
        if(i!=s){
          D[i] = +999999;
          P[i] = -1;
          C[i] = 0;
        }

      for(int i=0; i<N; i++){
          Q.push(i, D);
      }

      while(!Q.isEmpty()){
        u = Q.pop();
        for(int z=0; z<N; z++){
          if(M[u][z]!=0 && C[z] != 1){
            if((D[u] + M[u][z]) < D[z]){
              D[z] = D[u] + M[u][z];
              P[z] = u;
            }
          }
        }
        C[u] = 1;
        Q.ordena(D);
      }
      //debug



      for(int v=0; v<N; v++){
        theway.add(v,D[v],P[v]);;

      }

      return theway;
    }

}
