package fabiomarras;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Libri {
    private int codISBN;
    private String title;
    private int year;
    private int numPage;
    private String author;
    private String type;

    public Libri(int codISBN, String title, int year, int numPage, String author, String type) {
        this.codISBN = codISBN;
        this.title = title;
        this.year = year;
        this.numPage = numPage;
        this.author = author;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Libri{" +
                "codISBN=" + codISBN +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", numPage=" + numPage +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
