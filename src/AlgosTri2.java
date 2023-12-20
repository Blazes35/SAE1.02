public class AlgosTri2 {
    public static void triFusion(int []tab, int g, int d){
        int milieu= (d-g)/2;
        System.out.println(d-g);
        if(d-g>1) {
            triFusion(tab,g,milieu);
            triFusion(tab,n+1,d);
            Fusionner(tab,g,n,d);
        }
    }

    public static void Fusionner(int tab[], int debut, int milieu, int fin) {
        int n1 = milieu - debut + 1;
        int n2 = fin - milieu;

        int G[] = new int[n1];
        int D[] = new int[n2];{

            for (int i = 0; i < n1; i++)
                G[i] = tab[debut + i];
            for (int j = 0; j < n2; j++)
                D[j] = tab[milieu + 1 + j];

            int i, j, k;
            i = 0;
            j = 0;
            k = debut;

            while (i < n1 && j < n2) {
                if (G[i] <= D[j]) {
                    tab[k] = G[i];
                    i++;
                } else {
                    tab[k] = D[j];
                    j++;
                }
                k++;
            }
            while (i < n1) {
                tab[k] = G[i];
                i++;
                k++;
            }

            while (j < n2) {
                tab[k] = D[j];
                j++;
                k++;
            }
        }
    }
}
