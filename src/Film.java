import java.util.Comparator;

import java.io.Serializable;

public class Film {
    // ++++++++++++++++++++++++++++++++++++++
    // Attributs

    private String 	imdb_title_id;
    private String	title;
    private String	original_title;
    private int		year;
    private String	date_published;
    private String	genre;
    private String	duration;
    private String	country;
    private String	language;
    private String	director;
    private String	writer;
    private String	production_company;
    private String	actors;
    private String	description;
    private String	avg_vote;
    private String	votes;
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
        duration=data[6];
        country=data[7];
        language=data[8];
        director=data[9];
        writer=data[10];
        production_company=data[11];
        actors=data[12];
        description=data[13];
        avg_vote=data[14];
        votes=data[15];
        reste=data[16];
    }


    // ++++++++++++++++++++++++++++++++++++++
    // Comparateurs
    // ++++++++++++++++++++++++++++++++++++++
    public static Comparator<Film> compareTitle = new Comparator<Film>() {
        @Override
        public int compare(Film f1, Film f2) {
            return f1.title.compareToIgnoreCase(f2.title); // assuming 'title' is a String field in Film class
        }

    };

    public static Comparator<Film> compareYear = new Comparator<Film>() {
        @Override
        public int compare(Film f1, Film f2) {
            return f1.year - f2.year; // assuming 'year' is a int field in Film class
        }
    };





    // ++++++++++++++++++++++++++++++++++++++
    // Affichage
    // ++++++++++++++++++++++++++++++++++++++
    public String toString()
    {
        return (String.format("%-20s", title)
				+String.format("%-6s", year)
				/*+String.format("%-20s", genre)
				+String.format("%-6s", duration)
				+String.format("%-20s", country)
				+String.format("%-20s", director)
				+String.format("%-20s", writer)
				+String.format("%-20s", actors)
				+String.format("%-20s", description)
				+String.format("%-20s", avg_vote)
				+String.format("%-10s", votes)*/
                +"\n"
        );
    }
}
