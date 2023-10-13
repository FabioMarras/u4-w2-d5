package fabiomarras;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveElements {

    public static void rimuoviLibro(List<Libro> libri, int ISBN) {
        Iterator<Libro> listLibri = libri.iterator();
        while (listLibri.hasNext()) {
            Libro libro = listLibri.next();
            if (libro.getCodISBN() == ISBN) {
                listLibri.remove();
                System.out.println("Libro rimosso: " + libro);
            }
        }
    }
    public static void rimuoviRivista(List<Riviste> riviste, int ISBN) {
        Iterator<Riviste> listRiviste = riviste.iterator();
        while (listRiviste.hasNext()) {
            Riviste rivista = listRiviste.next();
            if (rivista.getCodISBN() == ISBN) {
                listRiviste.remove();
                System.out.println("Rivista rimossa: " + rivista);
            }
        }
    }
}
