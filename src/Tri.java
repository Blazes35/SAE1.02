import java.util.List;

public class Tri {
    public static void sortJava(List<Film> Films, int choix) {
        switch (choix) {
            case 12:
                Films.sort(Film.compareTitle);
                break;
            case 13:
                Films.sort(Film.compareYear);
                break;
            default:
                break;
        }
}

    /*public static void triSelection(List<Film> Films){

        //+++++++++++++++++++++++++++++++++++++++++++
        // A vous de coder !!!
        //+++++++++++++++++++++++++++++++++++++++++++
        int taille=Films.size(), minimum, tmp;
        Film filmtmp;

        for (int i=0;i<=taille-2;i++ ) {
            minimum=i;
            for (int j=i+1;j<=taille-1;j++) {
                if(tableau[j]<=tableau[minimum]) {
                    minimum=j;
                }
            }
            tmp=tableau[minimum];
            tableau[minimum]=tableau[i];
            tableau[i]=tmp;
        }
    }*/
}
