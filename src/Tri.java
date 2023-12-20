import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tri {
    public static void sortChooser(List<Film> Films) throws IOException {
        String choix = Clavier.lireString();
        long start;
        long end;
        switch (choix) {
            case "1":
                start = System.nanoTime();
                triFusion(Films);
                end = System.nanoTime();
                System.out.println("Temps d'exécution : " + ((float) (end - start)/1000000) + "ms");
                break;
            case "2":
                start = System.nanoTime();
                triSelection(Films, Film.compareYear);
                end = System.nanoTime();
                System.out.println("Temps d'exécution : " + ((float) (end - start)/1000000) + "ms");
                break;
            case "3":
                triSelection(Films, Film.compareGenre);
                break;
            case "4":
                triSelection(Films, Film.compareDuration);
                break;
            case "5":
                triSelection(Films, Film.compareCountry);
                break;
            case "6":
                triSelection(Films, Film.compareLanguage);
                break;
            case "7":
                triSelection(Films, Film.compareAvg_vote);
                break;
            case "8":
                triSelection(Films, Film.compareVotes);
                break;
            case "9":
                start = System.nanoTime();
                Films.sort(Film.compareTitle);
                end = System.nanoTime();
                System.out.println("Temps d'exécution : " + ((float) (end - start)/1000000) + "ms");
                break;
            case "10":
                Films.sort(Film.compareYear);
                break;
            default:
                System.out.println("Erreur de saisie veuillez rentrez un nombre entre 1 et 10\n");
                sortChooser(Films);
                break;
        }
    }

    public static void triSelection(List<Film> films, Comparator<Film> comparator){
        long star = System.nanoTime();
        int n = films.size();
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (comparator.compare(films.get(j), films.get(min_idx)) < 0) {
                    min_idx = j;
                }
            }
            // Swap films[i] and films[min_idx]
            Film temp = films.get(min_idx);
            films.set(min_idx, films.get(i));
            films.set(i, temp);
        }
        long stop = System.nanoTime();
        System.out.println("Temps d'exécution : " + ((float) (stop - star)/1000000) + "ms");
    }

    public static void triFusion(List<Film> films) {
        if (films.size() > 1) {
            List<Film> left = new ArrayList<>(films.subList(0, films.size() / 2));
            List<Film> right = new ArrayList<>(films.subList(films.size() / 2, films.size()));

            triFusion(left);
            triFusion(right);
            fusionner(films, left, right);
        }
    }

    public static void fusionner(List<Film> films, List<Film> left, List<Film> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getTitle().compareTo(right.get(j).getTitle()) <= 0) {
                films.set(k++, left.get(i++));
            } else {
                films.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            films.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            films.set(k++, right.get(j++));
        }
    }
}
