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
		
		
		System.out.println("temps de tri par s�lection : " + (float) (stop - start)/1000000 +" ms\n");
		
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
		System.out.println((d-g+1));
		
		int i=g, j=milieu+1;
		System.out.println(g+"   "+i+"   "+j+"    "+d);
		int k=0;
		
		while(i<=milieu || j <= d) {
			System.out.println("in");
			if (tab[i]<=tab[j] && i<=milieu) {
				tab2[k]=tab[i];
				i++;
			}else if (tab[i]>=tab[j]&& j<=d) {
				tab2[k]=tab[j]; 
				j++;
			}else {
				tab2[k]=tab[i];
				i++;
			}
			k++;
		}
		
		
		
		
		
		
		System.out.println(i<=milieu && j <= d);
		for (int values:tab2) {
			System.out.print(" "+values);
			
		}
		System.out.println();
		/*for (i=0; i<=d-g+1;i++) {
			tab[g+i]=tab2[i];
		}*/
	}

}