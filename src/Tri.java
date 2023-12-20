import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Tri {
    public static void sortJava(List<Film> Films) throws IOException {
        String choix = Clavier.lireString();
        switch (choix) {
            case "1":
                triSelection(Films, Film.compareTitle);
                break;
            case "2":
                triSelection(Films, Film.compareYear);
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
                Films.sort(Film.compareTitle);
                break;
            case "10":
                Films.sort(Film.compareYear);
                break;
            default:
                System.out.println("Erreur de saisie veuillez rentrez un nombre entre 1 et 10\n");
                sortJava(Films);
                break;
        }
    }

    public static void triSelection(List<Film> films, Comparator<Film> comparator){
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
    }
}
