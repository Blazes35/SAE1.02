import java.util.Comparator;
import java.util.List;

public class Filtre {
    private static String type = """
                            Quel type de filtre voulez-vous appliquer pour filtrer les données ?
                            1. inférieur ou égal
                            2. supérieur ou égal
                            3. entre deux valeurs comprises
                            """;

    public static void filterTitle(List<Film> Films) {
        System.out.println("Filtrer les films contenant: ");
        String valeur = Clavier.lireLigne();
        Films.removeIf(f -> !f.getTitle().contains(valeur));
    }

    public static void filterYear(List<Film> Films) {
        System.out.println(type);
        String choix = Clavier.lireString();
        switch (choix) {
            case "1":
                System.out.println("Filtrer les films avant ou pendant l'année: ");
                int valeur = Clavier.lireInt();
                Films.removeIf(f -> f.getYear() > valeur);
                break;
            case "2":
                System.out.println("Filtrer les films après ou pendant l'année: ");
                valeur = Clavier.lireInt();
                Films.removeIf(f -> f.getYear() < valeur);
                break;
            case "3":
                System.out.println("Filtrer les films entre:\nAnnée 1: ");
                int valeur1 = Clavier.lireInt();
                System.out.println("Et\nAnnée 2: ");
                int valeur2 = Clavier.lireInt();
                Films.removeIf(f -> f.getYear() < valeur1 || f.getYear() > valeur2);
                break;
            default:
                System.out.println("Erreur de saisie veuillez rentrez un nombre entre 1 et 3\n");
                filterYear(Films);
                break;
        }
    }

    public static void filterGenre(List<Film> Films) {
        System.out.println("Filtrer les films contenant: ");
        String valeur = Clavier.lireLigne();
        Films.removeIf(f -> !f.getGenre().contains(valeur));
    }

    public static void filterDuration(List<Film> Films) {
        System.out.println(type);
        String choix = Clavier.lireString();
        int valeur;
        switch (choix) {
            case "1":
                System.out.println("Filtrer les films durant au plus (en minutes): ");
                valeur = Clavier.lireInt();
                Films.removeIf(f -> f.getDuration() > valeur);
                break;
            case "2":
                System.out.println("Filtrer les films durant au moins (en minutes): ");
                valeur = Clavier.lireInt();
                Films.removeIf(f -> f.getDuration() < valeur);
                break;
            case "3":
                System.out.println("Filtrer les films durant entre:\ndurée 1: ");
                int valeur1 = Clavier.lireInt();
                System.out.println("Et\ndurée 2: ");
                int valeur2 = Clavier.lireInt();
                Films.removeIf(f -> f.getDuration() < valeur1 || f.getDuration() > valeur2);
                break;
            default:
                System.out.println("Erreur de saisie veuillez rentrez un nombre entre 1 et 3\n");
                filterDuration(Films);
                break;
        }
    }

    public static void filterCountry(List<Film> Films) {
        System.out.println("Filtrer les films contenant: ");
        String valeur = Clavier.lireLigne();
        Films.removeIf(f -> !f.getCountry().contains(valeur));
    }

    public static void filterLanguage(List<Film> Films) {
        System.out.println("Filtrer les films contenant: ");
        String valeur = Clavier.lireLigne();
        Films.removeIf(f -> !f.getLanguage().contains(valeur));
    }

    public static void filterDirector(List<Film> Films) {
        System.out.println("Filtrer les films contenant: ");
        String valeur = Clavier.lireLigne();
        Films.removeIf(f -> !f.getDirector().contains(valeur));
    }

    public static void filterWriter(List<Film> Films) {
        System.out.println("Filtrer les films contenant: ");
        String valeur = Clavier.lireLigne();
        Films.removeIf(f -> !f.getWriter().contains(valeur));
    }

    public static void filterActors(List<Film> Films) {
        System.out.println("Filtrer les films contenant: ");
        String valeur = Clavier.lireLigne();
        Films.removeIf(f -> !f.getActors().contains(valeur));
    }

    public static void filterDescription(List<Film> Films) {
        System.out.println("Filtrer les films contenant: ");
        String valeur = Clavier.lireLigne();
        Films.removeIf(f -> !f.getDescription().contains(valeur));
    }

    public static void filterVotes(List<Film> Films) {
        System.out.println(type);
        String choix = Clavier.lireString();
        int valeur;
        switch (choix) {
            case "1":
                System.out.println("Filtrer les films ayant un nombre de vote au plus: ");
                valeur = Clavier.lireInt();
                Films.removeIf(f -> f.getVotes() > valeur);
                break;
            case "2":
                System.out.println("Filtrer les films après ou pendant l'année: ");
                valeur = Clavier.lireInt();
                Films.removeIf(f -> f.getVotes() < valeur);
                break;
            case "3":
                System.out.println("Filtrer les films entre:\nAnnée 1: ");
                int valeur1 = Clavier.lireInt();
                System.out.println("Et\nAnnée 2: ");
                int valeur2 = Clavier.lireInt();
                Films.removeIf(f -> f.getVotes() < valeur1 || f.getVotes() > valeur2);
                break;
            default:
                System.out.println("Erreur de saisie veuillez rentrez un nombre entre 1 et 3\n");
                filterVotes(Films);
                break;
        }
    }

    public static void filterAvg_vote(List<Film> Films) {
        System.out.println(type);
        String choix = Clavier.lireString();
        int valeur;
        switch (choix) {
            case "1":
                System.out.println("Filtrer les films une notes inférieur ou égal à : ");
                valeur = Clavier.lireInt();
                Films.removeIf(f -> f.getAvg_vote() > valeur);
                break;
            case "2":
                System.out.println("Filtrer les films une notes supérieur ou égal à :");
                valeur = Clavier.lireInt();
                Films.removeIf(f -> f.getAvg_vote() < valeur);
                break;
            case "3":
                System.out.println("Filtrer les films noté entre:\nmoyenne 1: ");
                int valeur1 = Clavier.lireInt();
                System.out.println("Et\nmoyenne 2: ");
                int valeur2 = Clavier.lireInt();
                Films.removeIf(f -> f.getAvg_vote() < valeur1 || f.getAvg_vote() > valeur2);
                break;
            default:
                System.out.println("Erreur de saisie veuillez rentrez un nombre entre 1 et 3\n");
                filterAvg_vote(Films);
                break;
        }
    }

}