import java.util.Arrays;

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

    public void buscaProfundidade(int s, int[] p){
      boolean[] visitados = new boolean[N];
      buscaProfundidadeRecursiva(s, visitados, p);
    }

    public void buscaProfundidadeRecursiva(int vertice, boolean [] visitados, int[]p){
      visitados[vertice] = true;
      if (vertice == 6 || isinvetor(vertice,p)) {
        System.out.println("Visita: " + vertice);
      }
      for(int i=0; i<N; i++){
        if(M[vertice][i]!=0 && !visitados[i])
          buscaProfundidadeRecursiva(i, visitados,p);
      }
    }

    public void buscaLargura(int s, int[] p){
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

        if(isinvetor(u,p)){
          //debug
          System.out.println("vertice: "+u);

        }

        cor[u] = 2; // preto
      }

      // debug
      /*for(int v=0; v<N; v++){
       // if(v == 6 || isinvetor(v,p))
          System.out.println("vertice: " + v + " " + cor(cor[v]) + " " + d[v] + " " + pr[v]);
      }*/
    }

    public String cor(int valor){
    if(valor == 0){
      return "Branco";
    }
    else if (valor == 1){
      return "Cinza";
    }
    else if (valor == 2){
      return "Preto";
    }
    else {
      return "cor invalida";
    }
    }


    public int[] Dijkstra(int s){
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
      int[] theway= new int[N*3];
      int l=0;
      //debug
      /*System.out.println("Linha,peso,anterior");*/
      for(int v=0; v<N; v++){
        theway[l]= v;
        theway[l+1]=D[v];
        theway[l+2]=P[v];
        l+=3;
      }
      return theway;
    }

    public static void caminhomin(Grafo g,int local, int[] p) {
      int partida = local;
      int[] caminho;
      Pilha rotapizza = new Pilha();
      int ponto = 6;
      int e = 0;
      Integer[] entregue = new Integer[p.length];
      for (int i = 0; i < entregue.length; i++) {
        entregue[i] = null;
      }

      while (true) {
        System.out.println("Partida: "+ partida);
        caminho = g.Dijkstra(partida);
        /*for(int y = 0; y<caminho.length;y+=3)
        System.out.println("vertice "+caminho[y]+" "+caminho[y+1]+" "+caminho[y+2]);*/

        //achar o menor ponto

        Integer[] vmin = objetivoproximo(caminho, p, entregue);
        if (isinvetor(vmin[0], p) && !isinentregue(vmin[0], entregue)) {
          entregue[e] = vmin[0];
          e++;
        }
        while (vmin[0] != partida) {
          rotapizza.push(vmin[0], vmin[1], vmin[2]);
          for (int k = 0; k < caminho.length; k += 3) {
            if (caminho[k] == vmin[2]) {
              vmin[0] = caminho[k];
              vmin[1] = caminho[k + 1];
              vmin[2] = caminho[k + 2];
              break;
            }
          }
        }
        rotapizza.push(vmin[0], vmin[1], vmin[2]);

        while (!rotapizza.isEmpty()) {
          ponto = rotapizza.pop();
          System.out.println(ponto);
        }

        partida = ponto;

        if (saoiguais(p,entregue)) {
          caminho = g.Dijkstra(partida);
          System.out.println("Partida: "+ partida);
          /*System.out.println("Linha,peso,anterior");
          for (int v = 0; v < caminho.length - 2; v += 3) {
            System.out.println("vertice: " + caminho[v] + " " + caminho[v + 1] + " " + caminho[v + 2]);
          }*/
          for(int y = 0; y<caminho.length;y+=3)
            if(caminho[y] == local){
              vmin[0] = caminho[y];
              vmin[1] = caminho[y + 1];
              vmin[2] = caminho[y + 2];


            }

          while (vmin[0] != partida) {
            rotapizza.push(vmin[0], vmin[1], vmin[2]);
            for (int k = 0; k < caminho.length; k += 3) {
              if (caminho[k] == vmin[2]) {
                vmin[0] = caminho[k];
                vmin[1] = caminho[k + 1];
                vmin[2] = caminho[k + 2];

                break;
              }
            }
          }
          rotapizza.push(vmin[0], vmin[1], vmin[2]);
          while (!rotapizza.isEmpty()) {
            ponto = rotapizza.pop();
            System.out.println(ponto);
          }

          break;
        }

      }

/*
      System.out.println("Linha,peso,anterior");
      for (int v = 0; v < caminho.length - 2; v += 3) {
        System.out.println("vertice: " + caminho[v] + " " + caminho[v + 1] + " " + caminho[v + 2]);
      }*/

      //rotapizza.show();



    }

public static boolean saoiguais(int[] p, Integer[] entregue){
    Integer[] aux = new Integer[entregue.length];
    int caux=0;
    for( int i=0; i<aux.length;i++){
      aux[i]=null;
    }
    for(int i =0;i<p.length;i++){
      for(int j = 0; j<entregue.length;j++){
        if(entregue[j]!= null && entregue[j]==p[i]){
          aux[caux]= entregue[i];
          caux++;

          }
        }
      }

    for(caux = 0;caux<aux.length;caux++){
      if (aux[caux]== null){
        return false;
      }
    }

    return true;

}

    public static boolean isinvetor(int valor, int[] vetor){
        for(int i=0; i<vetor.length;i++){
          if (valor == vetor[i]){
            return true;
          }
        }
        return false;
    }

  public static boolean isinentregue(int valor, Integer[] vetor){
    for(int i=0; i<vetor.length;i++){
      if(vetor[i]!=null) {
        if (valor == vetor[i]) {
          return true;
        }
      }
    }
    return false;
  }

    public static Integer[] objetivoproximo(int[] caminho, int[] p, Integer[] entregue){
      Integer[] vmin = {null,null,null};
      for(int i=0;i<caminho.length-2;i+=3) {
        if (vmin[0] == null && isinvetor(caminho[i], p)) {

          if (!isinentregue(caminho[i], entregue)) {
            vmin[0] = caminho[i];
            vmin[1] = caminho[i + 1];
            vmin[2] = caminho[i + 2];
          }

        }
        if (vmin[0]!= null && isinvetor(caminho[i], p) && caminho[i + 1] < vmin[1]) {
          if (!isinentregue(caminho[i], entregue)) {
            vmin[0] = caminho[i];
            vmin[1] = caminho[i + 1];
            vmin[2] = caminho[i + 2];
          }
        }
      }
      return vmin;
    }

}
