public class Principal{

  public static void main(String args[]){


    Grafo g = new Grafo(26);
    int[] mapal = {0,3,1,2,3,3,25,1,24,3,4,3,5,2,6,3,7,2,9,2,10,3,23,3,14,3,19,3,17,3,16,2,12,3,13,3};
    int[] mapac = {1,2,7,2,3,25,4,5,24,19,20,4,20,23,5,23,6,23,10,2,9,8,10,8,12,11,23,11,14,20,11,20,16,20,16,18,18,16,15,15,18,8,13,22,22,11,15};
    int[] mapad = {1,3,1,3,11,7,5,3,11,11,7,11,5,7,3,3,1,3,11,1,5,7,7,7,5,7,3,7,5,7,7,7,5,7,5,3,5,5,5,5,5,5,7,3,5,5,7};
    int count = 0;

    int[] pedidos = {8,9,11,16,19,22,25};

    for(int i = 0;i< mapal.length-1;i+=2 ){
      for(int j =0; j<mapal[i+1];j++){
        g.InsereAresta(mapal[i], mapac[count], mapad[count], 0);
        count++;
      }
    }
    /*
    g.InsereAresta(0, 1, 1, 0);
    g.InsereAresta(0, 2, 1, 0);
    //g.InsereAresta(0, 3, 2, 0);
    g.InsereAresta(1, 3, 1, 0);
    g.InsereAresta(3, 4, 1, 0);
    g.InsereAresta(5, 1, 1, 0);
    g.InsereAresta(5, 6, 1, 0);
    g.InsereAresta(6, 7, 1, 0);
    g.InsereAresta(5, 7, 1, 0);*/

    // código solução

    g.ImprimeGrafo();
    //g.entregaspizza(g,pedidos);

    if(g.ExisteAresta(0, 1))
      System.out.println("Existe aresta entre 0 e 1");

    if(g.ExisteAresta(0, 3))
      System.out.println("Existe aresta entre 0 e 3");

    System.out.println("--------------");
    //g.buscaProfundidade(0);
    g.buscaLargura(6);

    //g.Dijkstra(0);


  }

}
