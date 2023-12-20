import java.util.*;

public class AlgosTri {

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
		
		start = System.nanoTime(); 
		triSelection();
		stop = System.nanoTime();
		
		if(AFFICHAGE) afficherTableau();
		
		
		System.out.println("temps de tri par sélection : " + (float) (stop - start)/1000000 +" ms\n");
		
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
	
	public static void triSelection(){
		
		//+++++++++++++++++++++++++++++++++++++++++++
		// A vous de coder !!!
		//+++++++++++++++++++++++++++++++++++++++++++
		int minimum;
		int tmp;
		
		for (int i=0;i<=n-2;i++ ) {
			minimum=i;
			for (int j=i+1;j<=n-1;j++) {
				if(tableau[j]<=tableau[minimum]) {
					minimum=j;
				}
			}
			tmp=tableau[minimum];
			tableau[minimum]=tableau[i];
			tableau[i]=tmp;
		}		
	}
	
	public static void triFusion(int []tab, int g, int d){
		//+++++++++++++++++++++++++++++++++++++++++++		
		// A vous de coder !!!
		//+++++++++++++++++++++++++++++++++++++++++++
		
		if(d>g) {
			int milieu = (d+g)/2;
			triFusion(tab,g,milieu);
			triFusion(tab, milieu+1, d);
			fusionner(tab, g, milieu, d);
		}
	}
	
	public static void fusionner(int[] tab, int g, int milieu, int d) {
		int[] tab2= new int[d-g+1];
		int i=g, j=milieu+1, k=0;
	
		while(i<=milieu && j <= d) {
			if (tab[i]<=tab[j]) {
				tab2[k]=tab[i];
				i++;
			} else {
				tab2[k]=tab[j]; 
				j++;
			}
			k++;
		}
	
		// Copy the remaining elements of left subarray, if there are any
		while (i <= milieu) {
			tab2[k] = tab[i];
			i++;
			k++;
		}
	
		// Copy the remaining elements of right subarray, if there are any
		while (j <= d) {
			tab2[k] = tab[j];
			j++;
			k++;
		}
	
		// Copy back the merged elements to original array
		for (i = g, k = 0; i <= d; i++, k++) {
			tab[i] = tab2[k];
		}
	}

}