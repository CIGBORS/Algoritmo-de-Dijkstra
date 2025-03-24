public class GrafoLA{
  int N;
  Node vertices[];

  public GrafoLA(int qv){
    N = qv;
    vertices = new Node[qv];
    for(int i=0; i<vertices.length; i++)
      vertices[i] = null;
  }

  public void InsereAresta(int v1, int v2, int peso, int direcionado){
      // Node[v1] -> v2
      if(vertices[v1]==null)
        vertices[v1] = new Node(v2, peso);
      else
        vertices[v1].push(v2, peso);

      // se direcionado == 0  =>  Node[v2] -> v1
      if(direcionado == 0){
        if(vertices[v2]==null)
          vertices[v2] = new Node(v1, peso);
        else
          vertices[v2].push(v1, peso);
      }
  }

  public void ImprimeGrafo(){
      for(int i=0; i<vertices.length; i++){
        System.out.print("Vertice " + i + ": ");
        if(vertices[i] != null)
          vertices[i].ImprimeGrafo();
        System.out.println();
      }
  }

  public boolean ExisteAresta(int v1, int v2){
    if(vertices[v1]!=null)
      return vertices[v1].ExisteAresta(v2);
    else
      return false;
  }

  public void buscaProfundidade(int s){
    boolean[] visitados = new boolean[vertices.length];
    buscaProfundidadeRecursiva(s, visitados);
  }

  public void buscaProfundidadeRecursiva(int vertice, boolean [] visitados){
    Node aux = vertices[vertice]; // aux recebe o endereço do primeiro node da lista encadeada na linha vertice
    visitados[vertice] = true;  // marca o vertice como visitado
    System.out.println("Visita: " + vertice);
    // loop para verificar os nodes vizinhos de vertice que ainda não foram visitados
    while(aux!=null){
      if(!visitados[aux.getVertice()]) // se achar um node não visitado, faz a visita a partir dele
        buscaProfundidadeRecursiva(aux.getVertice(), visitados);
      aux=aux.getNext(); // aux recebe o endereço do próximo nó da lista de adjacencia
    }
  }

  public void buscaLargura(int s){
    Fila f = new Fila(N);
    int cor[] = new int[N];  // 0 = BRANCO, 1 = CINZA, 2 = PRETO
    int d[] = new int[N];    // distancia
    int pr[] = new int[N];   // precedente
    int u, v;
    Node vertice;

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
      vertice = vertices[u];
      while(vertice!=null){
        v = vertice.getVertice();
        if(cor[v] == 0){
          cor[v] = 1;  // cinza
          d[v] = d[u] + vertice.getPeso();
          pr[v] = u;
          f.push(v);
        }
        vertice = vertice.getNext();
      }
      cor[u] = 2; // preto
    }
    // debug

    for(int i=0; i<N; i++){
        System.out.println("vertice: " + i + " " + cor[i] + " " + d[i] + " " + pr[i]);
    }
  }
}
