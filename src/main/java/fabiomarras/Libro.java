package fabiomarras;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class Libro {
    private int codISBN;
    private String title;
    private int year;
    private int numPage;
    private String author;
    private String type;
    Random rndm = new Random();
    public Libro(String title, int year, int numPage, String author, String type) {
        this.codISBN = rndm.nextInt(1000, 9900000);
        this.title = title;
        this.year = year;
        this.numPage = numPage;
        this.author = author;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "codISBN=" + codISBN +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", numPage=" + numPage +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public int getCodISBN() {
        return codISBN;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getNumPage() {
        return numPage;
    }

    public String getType() {
        return type;
    }
}
