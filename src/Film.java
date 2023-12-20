import java.util.Comparator;

import java.io.Serializable;

public class Film implements Serializable {
    // ++++++++++++++++++++++++++++++++++++++
    // Attributs

    private String 	imdb_title_id;
    private String	title;
    private String	original_title;
    private int		year;
    private String	date_published;
    private String	genre;
    private int     duration;
    private String	country;
    private String	language;
    private String	director;
    private String	writer;
    private String	production_company;
    private String	actors;
    private String	description;
    private float   avg_vote;
    private int	    votes;
    private String	reste;


    // ++++++++++++++++++++++++++++++++++++++
    // Constructeur
    // ++++++++++++++++++++++++++++++++++++++
    public Film(String[] data) {
        imdb_title_id=data[0];
        title=data[1];
        original_title=data[2];
        year=Integer.parseInt(data[3]);
        date_published=data[4];
        genre=data[5];
        duration= Integer.parseInt(data[6]);
        country=data[7];
        language=data[8];
        director=data[9];
        writer=data[10];
        production_company=data[11];
        actors=data[12];
        description=data[13];
        avg_vote= Float.parseFloat(data[14]);
        votes= Integer.parseInt(data[15]);
        reste=data[16];
    }


    // ++++++++++++++++++++++++++++++++++++++
    // Comparateurs
    // ++++++++++++++++++++++++++++++++++++++
    public static Comparator<Film> compareTitle = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.title.compareToIgnoreCase(f2.title); // assuming 'title' is a String field in Film class
        }

    };

    public static Comparator<Film> compareYear = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.year - f2.year; // assuming 'year' is a int field in Film class
        }
    };

    public static Comparator<Film> compareGenre = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.genre.compareToIgnoreCase(f2.genre); // assuming 'genre' is a String field in Film class
        }
    };

    public static Comparator<Film> compareDuration = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.duration - f2.duration; // assuming 'duration' is a int field in Film class
        }
    };

    public static Comparator<Film> compareCountry = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.country.compareToIgnoreCase(f2.country); // assuming 'country' is a String field in Film class
        }
    };

    public static Comparator<Film> compareLanguage = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.language.compareToIgnoreCase(f2.language); // assuming 'language' is a String field in Film class
        }
    };

    public static Comparator<Film> compareAvg_vote = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return (int) (f1.avg_vote - f2.avg_vote); // assuming 'avg_vote' is a float field in Film class
        }
    };

    public static Comparator<Film> compareVotes = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.votes - f2.votes; // assuming 'votes' is a int field in Film class
        }
    };


    // ++++++++++++++++++++++++++++++++++++++
    // Affichage
    // ++++++++++++++++++++++++++++++++++++++
    public String toString() {
        return (String.format("%-20s", title)
				+String.format("%-6s", year)
				+String.format("%-20s", genre)
				+String.format("%-6s", duration)
				+String.format("%-20s", country)
				+String.format("%-20s", director)
				+String.format("%-20s", writer)
				+String.format("%-20s", actors)
				+String.format("%-20s", description)
				+String.format("%-20s", avg_vote)
				+String.format("%-10s", votes)
                +String.format("%s", reste)
                +"\n");
    }

    // ++++++++++++++++++++++++++++++++++++++
    // Getters
    // ++++++++++++++++++++++++++++++++++++++
    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public String getCountry() {
        return country;
    }

    public String getLanguage() {
        return language;
    }

    public String getDirector() {
        return director;
    }

    public String getWriter() {
        return writer;
    }

    public String getActors() {
        return actors;
    }

    public String getDescription() {
        return description;
    }

    public int getVotes() {
        return votes;
    }

    public float getAvg_vote() {
        return avg_vote;
    }
}
