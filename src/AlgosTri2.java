import java.util.*;

public class AlgosTri2 {
    static int [] tableau;
    static int [] copieTab;
    static int n=16;
    static boolean AFFICHAGE=true;

    public static void main(String[] args) {

        long start,stop;  //sert pour calculer le temps des tris

        tableau=new int[n];

        Random r=new Random();
        for(int i=0;i<=n-1;i++)
            tableau[i]=r.nextInt(1000);	//on remplit le tableau al�atoirement

        copieTab=(int[]) tableau.clone(); // on garde une copie pour pouvoir appliquer diff�rentes m�thodes de tri sur le m�me jeu de donn�es

        if(AFFICHAGE) afficherTableau();
        System.out.println();

        /*start = System.nanoTime();
        triSelection();
        stop = System.nanoTime();

        if(AFFICHAGE) afficherTableau();


        System.out.println("temps de tri par s�lection : " + (float) (stop - start)/1000000 +" ms\n");*/

        tableau=(int[]) copieTab.clone(); // on remet le tableau dans l'�tat initial

        start = System.nanoTime();
        triFusion(tableau,0,n-1);
        stop = System.nanoTime();

        if(AFFICHAGE) afficherTableau();

        System.out.println("temps de tri fusion : " + (float) (stop - start)/1000000 +" ms\n");
    }

    public static void afficherTableau(){

        System.out.print("Tableau :");

        for(int i=0;i<=n-1;i++)
            System.out.print(" "+tableau[i]);

        System.out.println(".");

    }

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
