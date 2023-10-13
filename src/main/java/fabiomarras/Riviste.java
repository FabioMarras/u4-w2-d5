package fabiomarras;

public class Riviste {
    private int codISBN;
    private String title;
    private int year;
    private int numPage;
    private String periodicità;

    public static final String SETTIMANALE = "Settimanale";
    public static final String MENSILE = "Mensile";
    public static final String SEMESTRALE = "Semestrale";

    public Riviste(int codISBN, String title, int year, int numPage, String periodicità) {
        this.codISBN = codISBN;
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
}
