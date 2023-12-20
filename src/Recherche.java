import java.util.List;

public class Recherche {
    public static void rechercheLineaire(List<Film> Films, String valeur) {
        int i = 0;
        boolean trouve = false;
        while (i < Films.size() && !trouve) {
            if (Films.get(i).getTitle().equals(valeur)) {
                trouve = true;
            } else {
                i++;
            }
        }
        if (trouve) {
            System.out.println(Films.get(i));
        } else {
            System.out.println("Le film " + valeur + " n'est pas dans la liste");
        }
    }

    public static void rechercheDichotomique(List<Film> Films, int left, int right,String valeur) {
        int mid = (left + right) / 2;
        if (left > right) {
            System.out.println("""
            Le film " + valeur + " n'est pas dans la liste
            """);


        }else {
            int comparaison = Films.get(mid).getTitle().compareToIgnoreCase(valeur);
            if (comparaison < 0) {
                rechercheDichotomique(Films, mid + 1, right, valeur);
            } else if (comparaison > 0) {
                rechercheDichotomique(Films, left, mid - 1, valeur);
            } else {
                System.out.println(Films.get(mid));
            }
        }
    }
}
