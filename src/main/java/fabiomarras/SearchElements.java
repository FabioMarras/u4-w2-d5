package fabiomarras;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SearchElements {
    public static void ricercaPerIsbnLibro(List<Libro> libri, int isbnUtente) {
        Predicate<Libro> categoryISBN = book -> book.getCodISBN() == isbnUtente;
        List<Libro> libriIsbn = libri.stream().filter(categoryISBN).collect(Collectors.toList());
        if (libriIsbn.isEmpty()) {
            System.out.println("Mi dispiace non abbiamo libri del " + isbnUtente);
        } else {
            libriIsbn.forEach(System.out::println);
        }
    }
    public static void ricercaPerAnnoLibro(List<Libro> libri, int anno) {
        Predicate<Libro> categoryAnno = book -> book.getYear() == anno;
        List<Libro> libriAnno = libri.stream().filter(categoryAnno).collect(Collectors.toList());
        if (libriAnno.isEmpty()) {
            System.out.println("Mi dispiace non abbiamo libri del " + anno);
        } else {
            libriAnno.forEach(System.out::println);
        }
    }
    public static void ricercaPerAutoreLibro (List<Libro> libri, String author) {
        Predicate<Libro> categoryAuthor = book -> book.getAuthor().equals(author);
        List<Libro> libriIsbn = libri.stream().filter(categoryAuthor).collect(Collectors.toList());
        if (libriIsbn.isEmpty()) {
            System.out.println("Mi dispiace non abbiamo libri del " + author);
        } else {
            libriIsbn.forEach(System.out::println);
        }
    }
    public static void ricercaPerIsbnRivista (List<Riviste> riviste, int isbnUtente) {
        Predicate<Riviste> categoryISBN = rivista -> rivista.getCodISBN() == isbnUtente;
        List<Riviste> rivistaIsbn=  riviste.stream().filter(categoryISBN).toList();
        if (rivistaIsbn.isEmpty()) {
            System.err.println("Mi dispiace non abbiamo riviste con ISBN: " + isbnUtente);
        } else {
            rivistaIsbn.forEach(System.out::println);
        }
    }
    public static void ricercaPerAnnoRivista(List<Riviste> riviste, int anno) {
        Predicate<Riviste> categoryAnno = rivista -> rivista.getYear() == anno;
        List<Riviste> rivistaAnno = riviste.stream().filter(categoryAnno).toList();
        if (rivistaAnno.isEmpty()) {
            System.err.println("Mi dispiace non abbiamo riviste del " + anno);
        } else {
            rivistaAnno.forEach(System.out::println);
        }
    }
}
