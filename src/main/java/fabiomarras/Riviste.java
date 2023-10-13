package fabiomarras;

import java.util.Random;

public class Riviste {
    private int codISBN;
    private String title;
    private int year;
    private int numPage;
    private String periodicità;
    Random rndm = new Random();

    public static final String SETTIMANALE = "Settimanale";
    public static final String MENSILE = "Mensile";
    public static final String SEMESTRALE = "Semestrale";

    public Riviste(String title, int year, int numPage, String periodicità) {
        this.codISBN = rndm.nextInt(1000, 9900000);
        this.title = title;
        this.year = year;
        this.numPage = numPage;
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "codISBN=" + codISBN +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", numPage=" + numPage +
                ", periodicità='" + periodicità + '\'' +
                '}';
    }

    public int getCodISBN() {
        return codISBN;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public int getNumPage() {
        return numPage;
    }

    public String getPeriodicità() {
        return periodicità;
    }
}
