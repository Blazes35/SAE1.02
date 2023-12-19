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
        String[] bases = {"IMDbmoviesCUT100", "IMDbnamesCUT1000", "IMDbratingsCUT1000",
                          "IMDbrateCUT40000", "ImdbtitleprinciplesFULL"};

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
}