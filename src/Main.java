import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException  {
        List<Film> Films = new LinkedList<Film>();
        int choix=menuPrincipale();
        chargerDonnees(choix, Films);
    }

    public static void sortJavaByTitle(List<Film> Films) {
        //Replace Collections.sort(Films, comparators) by Films.sort(comparators)
        Films.sort(Film.compareTitle);
    }

    public static void sortJavaByYear(List<Film> Films) {
        //Replace Collections.sort(Films, comparators) by Films.sort(comparators)
        Films.sort(Film.compareYear);
    }

    public static void affichageFilms(List<Film> Films) {
        for (Film film : Films) {
            System.out.println(film);
        }
    }

    public static int menuPrincipale() {
        System.out.println("Comment souhaitez vous trier les informations :\n"+
                            "1. Charger les données\n"+
                            "2. trier les données\n"+
                            "3. Filtrer les données\n"+
                            "4. Rechercher un film\n"+
                            "5. Suppresion un à un\n"+
                            "6. Sauvergarder\n");
        return Clavier.lireInt();
    }

    public static void chargerDonnees(int choix, List<Film> Films) throws IOException {
        String[] bases = {"IMDbmoviesCUT100", "IMDbnmoviesCUT1000", "IMDbmoviesCUT1000.tsv",
                          "IMDbmoviesCUT40000.tsv", "IMDbmoviesFULL.tsv"};

        int i =0;
        for (String base : bases) {
            i++;
            System.out.println(i+". "+base);
        }
        int choixbase=Clavier.lireInt();

        System.out.println("Chargement des données");
        BufferedReader tsvReader = new BufferedReader(new FileReader(bases[choixbase-1]+".tsv"));

        String row=new String();
        row = tsvReader.readLine();
        while(tsvReader.ready()) {
            row = tsvReader.readLine();
            String[] data= row.split("\t", 17);
            Films.add(new Film(data));
        }
        tsvReader.close();

        affichageFilms(Films);
    }

    /*System.out.println("Comment souhaitez vous trier les informations :");
                System.out.println("1. Par titre");
                System.out.println("2. Par annÃ©e de rÃ©alisation");
                System.out.println("3. Par genre");
                System.out.println("4. Par durÃ©e");
                System.out.println("5. Par pays de production");
                System.out.println("6. Par langue");
                System.out.println("7. Par rÃ©alisateur");
                System.out.println("8. Par scÃ©nariste");
                System.out.println("9. Par acteur");
                System.out.println("10. Par Description");
                System.out.println("11. Par nombre de votes de spectateurs");
                System.out.println("12. Par note");*/




}

