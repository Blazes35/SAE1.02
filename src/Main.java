import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class Main {

    public static void main(String[] args) throws IOException  {
        System.out.println();
        List<Film> Films = new LinkedList<>();
        menuPrincipale(Films);
    }

    public static void affichageFilms(List<Film> Films) {

        for (Film film : Films) {
            System.out.println(film);
        }
    }

    public static void menuPrincipale(List<Film> Films) throws  IOException {
        System.out.println("""
                \n***************************************
                Comment souhaitez vous trier les informations :
                1. Charger les données
                2. trier les données
                3. Filtrer les données
                4. Rechercher un film
                5. Afficher les données 
                6. Suppresion un à un
                7. Sauvergarder
                ***************************************\n
                """);

        String choix = Clavier.lireString();
        switch (choix) {
            case "1":
                chargerDonnees(Films);
                break;
            case "2":
                triFilms(Films);
                break;
            case "3":
                filtrerFilms(Films);
                break;
            case "4":
                Recherche.rechercheLineaire(Films, Clavier.lireString());
                break;
            case "5":
                affichageFilms(Films);
                menuPrincipale(Films);
                break;
            case "6":
                supprimerFilm(Films);
                break;
            case "7":
                //sauvegarderFilms(Films);
                break;
            default:
                System.out.println("Erreur de saisie veuillez rentrez un nombre entre 1 et 6\n");
                menuPrincipale(Films);
                break;
        }
    }

    public static void chargerDonnees(List<Film> Films) throws IOException {
        String[] bases = {"IMDbmoviesCUT100", "IMDbmoviesCUT1000", "IMDbmoviesCUT10000",
                "IMDbmoviesCUT40000", "IMDbmoviesFULL"};

        int i =0;
        for (String base : bases) {
            i++;
            System.out.println(i+". "+base);
        }
        int choixbase=Clavier.lireInt();

        System.out.println("Chargement des données");
        BufferedReader tsvReader = new BufferedReader(new FileReader(bases[choixbase-1]+".tsv"));

        String row = tsvReader.readLine();
        while(tsvReader.ready()) {
            row = tsvReader.readLine();
            String[] data= row.split("\t", 17);
            Films.add(new Film(data));
        }
        tsvReader.close();

        affichageFilms(Films);
        menuPrincipale(Films);
    }

    public static void triFilms(List<Film> Films) throws IOException {
        System.out.println("""
        Comment souhaitez vous trier les informations :
        1. Par titre
        2. Par année de réalisation
        3. Par genre
        4. Par durée
        5. Par pays de production
        6. Par langue
        7. Par nombre de votes
        8. Par note
        9. Par tri Java par titre
        10. Par tri Java par année
        """);
        Tri.sortJava(Films);
        affichageFilms(Films);
        menuPrincipale(Films);
    }

    public static void filtrerFilms(List<Film> Films) throws IOException {
        System.out.println("""
        Comment souhaitez vous filtrer les informations :
        1. Par titre
        2. Par année de réalisation
        3. Par genre
        4. Par durée
        5. Par pays de production
        6. Par langue
        7. Par réalisateur
        8. Par scénariste
        9. Par acteur
        10. Par Description
        11. Par nombre de votes de spectateurs
        12. Par note
        """);


        int choix = Clavier.lireInt();
        String valeur;
        switch (choix) {
            case 1:
                Filtre.filterTitle(Films, Clavier.lireString());
                break;
            case 2:
                Filtre.filterYear(Films);
                break;
            case 3:
                Filtre.filterGenre(Films, Clavier.lireString());
                break;
            case 4:
                Filtre.filterDuration(Films);
                break;
            case 5:
                Filtre.filterCountry(Films, Clavier.lireString());
                break;
            case 6:
                Filtre.filterLanguage(Films, Clavier.lireString());
                break;
            case 7:
                Filtre.filterDirector(Films, Clavier.lireString());
                break;
            case 8:
                Filtre.filterWriter(Films, Clavier.lireString());
                break;
            case 9:
                Filtre.filterActors(Films, Clavier.lireString());
                break;
            case 10:
                Filtre.filterDescription(Films, Clavier.lireString());
                break;
            case 11:
                Filtre.filterVotes(Films);
                break;
            case 12:
                Filtre.filterAvg_vote(Films);
                break;
            default:
                System.out.println("Erreur de saisie veuillez rentrez un nombre entre 1 et 12\n");
                filtrerFilms(Films);
                break;
        }

        affichageFilms(Films);
        menuPrincipale(Films);
    }

    public static void supprimerFilm(List<Film> Films) throws IOException {
        System.out.println("""
            \n***************************************
            Souhaitez vous supprimer les informations stockées :
            1. Oui
            2. Non
            ***************************************\n
            """);
        int choix = Clavier.lireInt();
        ListIterator<Film> iterator = Films.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        affichageFilms(Films);
        menuPrincipale(Films);
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

