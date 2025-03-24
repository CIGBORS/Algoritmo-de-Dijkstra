public class Nodep {
        private Integer linha;
        private Integer coluna;
        private Integer distancia;
        Nodep proximo ;


        public Nodep(int linha, int coluna,int distancia){
            this.linha = linha;
            this.coluna = coluna;
            this.distancia = distancia;
            this.proximo = null;
        }

        public void push(int linha, int coluna,int distancia){
        if(proximo == null)
            proximo = new Nodep(linha,coluna,distancia);
            else
                proximo.push(linha,coluna,distancia);


    }

    // public int[] pmin(int partida, int p[], Integer menor[]){
    //         for(int i=0; i<p.length;i++){
    //             if (menor[0]==null&& p[i] == linha){
    //                 menor[0]= linha;
    //                 menor[1]=coluna;
    //                 menor[2]=distancia;
    //             }
    //             if(menor[0]>linha){
    //                 menor[0]= linha;
    //                 menor[1]=coluna;
    //                 menor[2]=distancia;
    //             }
    //     }
    //         if(proximo!=null)
    //         menor = proximo.pmin(partida,p[],menor[]);

    //         return p;
    // }
        public void show(){
            System.out.println("vertice: " + linha + " " + coluna + " " + distancia);
            if (proximo!= null){
                proximo.show();
            }
        }
}
