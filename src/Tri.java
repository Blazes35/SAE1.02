import java.util.Comparator;
import java.util.List;

public class Tri {
    public static void sortJava(List<Film> Films, int choix) {
        switch (choix) {
            case 1:
                triSelection(Films, Film.compareTitle);
                break;
            case 2:
                triSelection(Films, Film.compareYear);
                break;
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
