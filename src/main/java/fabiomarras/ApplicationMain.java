package fabiomarras;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Supplier;

public class ApplicationMain {
    public static void main(String[] args) {

        //Qui creiamo 100 libri casuali
        Supplier<Libro> booksSupplier = () -> {
            Faker faker = new Faker(Locale.ITALY);
            Random rndm = new Random();
            return new Libro(faker.book().title(), rndm.nextInt(2000, 2024), rndm.nextInt(0, 100), faker.book().author(), faker.book().genre());
        };
        List<Libro> libri = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            libri.add(booksSupplier.get());
        }
        //libri.forEach(System.out::println);

        //Qui creiamo 100 riviste casuali
        Supplier<Riviste> RivisteSupplier = () -> {
            Faker faker = new Faker(Locale.ITALY);
            Random rndm = new Random();
            String[] randomPeriodicità = {Riviste.SETTIMANALE, Riviste.MENSILE, Riviste.SEMESTRALE};
            String periodicitàCasuale = randomPeriodicità[rndm.nextInt(3)];
            return new Riviste(faker.lorem().word(), rndm.nextInt(2000, 2024), rndm.nextInt(0, 100), periodicitàCasuale);
        };
        List<Riviste> riviste = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            riviste.add(RivisteSupplier.get());
        }
        //riviste.forEach(System.out::println);

        //Creiamo archivio
        List<Object> Archivio = new ArrayList<>();
        Archivio.add(libri);
        Archivio.add(riviste);
        Archivio.forEach(System.out::println);

        //creazione file
        File file = new File("src/listArchivio.txt");
        try{
            StringBuilder ListStringArchivio = new StringBuilder();
            for (Libro libro : libri) {
                String listProduct = "Libro: " + libro.getTitle() + "  Anno: " + libro.getYear() + " Pagine: " + libro.getNumPage() + " Autore: " + libro.getAuthor();
                ListStringArchivio.append(listProduct).append(System.lineSeparator());
            }
            for (Riviste Riviste : riviste) {
                String listProduct = "Rivista: " + Riviste.getTitle() + "  Anno: " + Riviste.getYear() + " Pagine: " + Riviste.getNumPage() + " Periodicità: " + Riviste.getPeriodicità();
                ListStringArchivio.append(listProduct).append(System.lineSeparator());
            }

            FileUtils.writeStringToFile(file, ListStringArchivio  + System.lineSeparator(), StandardCharsets.UTF_8);
        }catch (IOException e) {
            System.err.println(e.getMessage());
        }

        //Scanner per aggiunta, rimozione e ricerca
        Scanner input = new Scanner(System.in);
        System.out.println("Benvenuto! digita 1 per AGGIUNGERE UN LIBRO, digita 2 per AGGIUNGERE UNA RIVISTA: oppure digita 3 per CANCELLARNE UNO, digita 4 per CERCARE UN LIBRO/RIVISTA");
        int numero = Integer.parseInt(input.nextLine());
        Libro nuovo = null;

        //caso 1, aggiunta libro
        if (numero == 1) {
            System.out.println("Stai aggiungendo un libro! Inserisci il suo titolo:");
            String title = input.nextLine();
            System.out.println("Inserisci il suo anno:");
            int year = Integer.parseInt(input.nextLine());
            System.out.println("Inserisci il numero di pagine:");
            int page = Integer.parseInt(input.nextLine());
            System.out.println("Inserisci il suo autore:");
            String author = input.nextLine();
            System.out.println("Inserisci il suo genere:");
            String type = input.nextLine();
            nuovo = new Libro(title, year, page, author, type);
            System.out.println("HAI INSERITO: " + nuovo);
            libri.add(nuovo);
            System.out.println("ECCO LA LISTA DEI LIBRI DISPONIBILI AGGIORNATA!");
            libri.forEach(System.out::println);

            //caso 2, aggiunta rivista
        } else if (numero == 2) {
            System.out.println("Stai aggiungendo una rivista! Inserisci il suo titolo:");
            String title = input.nextLine();
            System.out.println("Inserisci il suo anno:");
            int year = Integer.parseInt(input.nextLine());
            System.out.println("Inserisci il numero di pagine:");
            int page = Integer.parseInt(input.nextLine());
            System.out.println("Digita 1 se Settimanale, 2 se Mensile, 3 se Semestrale:");
            int Intperiodicità = Integer.parseInt((input.nextLine()));
            String periodicità = "";
            switch (Intperiodicità) {
                case 1:
                    periodicità = "Settimanale";
                    break;
                case 2:
                    periodicità = "Mensile";
                    break;
                case 3:
                    periodicità = "Semestrale";
                    break;
                default:
                    System.err.println("Non hai inserito un opzione valida, riprova");
            }

            Riviste nuovo2 = new Riviste(title, year, page, periodicità);
            System.out.println("HAI INSERITO: " + nuovo2);
            riviste.add(nuovo2);
            System.out.println("ECCO LA LISTA DELLE RIVISTE DISPONIBILI AGGIORNATA!");
            riviste.forEach(System.out::println);

            //caso 3, rimozione libro o rivista
        } else if (numero == 3) {
            System.out.println("Cosa vuoi rimuovere? un libro o una rivista?");
            String scelta = input.nextLine();
            if (scelta.equals("libro")) {
                System.out.println("Inserisci l'ISBN del libro da rimuovere:");
                int codice = Integer.parseInt(input.nextLine());
                RemoveElements.rimuoviLibro(libri, codice);
                System.out.println("ECCO LA LISTA DEI LIBRI DISPONIBILI AGGIORNATA!");
                libri.forEach(System.out::println);
            } else if (scelta.equals("rivista")) {
                System.out.println("Inserisci l'ISBN della rivista da rimuovere:");
                int codice = Integer.parseInt(input.nextLine());
                RemoveElements.rimuoviRivista(riviste, codice);
                System.out.println("ECCO LA LISTA DELLE RIVISTE DISPONIBILI AGGIORNATA!");
                riviste.forEach(System.out::println);
            } else {
                System.err.println("Scelta non valida, inserisci o libro o rivista");
            }

            //caso 4, ricerca
        } else if (numero == 4) {
            System.out.println("Digita 1 se vuoi cercare un libro, 2 se vuoi cercare una rivista");
            int scelta1 = Integer.parseInt(input.nextLine());
            if (scelta1 == 1) {
                System.out.println("Digita 1 se vuoi cercare per ISBN, digita 2 se vuoi cercare per anno, digita 3 se vuoi cercare per autore ");
                int scelta = Integer.parseInt(input.nextLine());
                if (scelta == 1) {
                    System.out.println("RICERCA PER ISBN:");
                    int isbn = Integer.parseInt(input.nextLine());
                    SearchElements.ricercaPerIsbnLibro(libri, isbn);
                } else if (scelta == 2) {
                    System.out.println("RICERCA PER ANNO:");
                    int year = Integer.parseInt(input.nextLine());
                    SearchElements.ricercaPerAnnoLibro(libri, year);
                } else if (scelta == 3) {
                    System.out.println("RICERCA PER autore:");
                    String author = input.nextLine();
                    SearchElements.ricercaPerAutoreLibro(libri, author);
                } else {
                    System.err.println("Scelta non valida, digita 1 o 2 o 3");
                }
            } else if (scelta1 == 2) {
                System.out.println("Digita 1 se vuoi cercare per ISBN, digita 2 se vuoi cercare per anno ");
                int scelta = Integer.parseInt(input.nextLine());
                if (scelta == 1) {
                    System.out.println("RICERCA PER ISBN:");
                    int isbn = Integer.parseInt(input.nextLine());
                    SearchElements.ricercaPerIsbnRivista(riviste, isbn);
                } else if (scelta == 2) {
                    System.out.println("RICERCA PER ANNO:");
                    int year = Integer.parseInt(input.nextLine());
                    SearchElements.ricercaPerAnnoRivista(riviste, year);
                } else {
                    System.err.println("Scelta non valida, digita 1 o 2 ");
                }
            }
        }

    }
}
