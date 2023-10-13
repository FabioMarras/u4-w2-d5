package fabiomarras;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.function.Supplier;

public class ApplicationMain {
    public static void main(String[] args) {

        //Qui creiamo 100 libri casuali
        Supplier<Libri> booksSupplier = () -> {
            Faker faker = new Faker(Locale.ITALY);
            Random rndm = new Random();
            return new Libri(rndm.nextInt(1000, 9900000), faker.book().title(), rndm.nextInt(2000, 2024), rndm.nextInt(0, 100), faker.book().author(), faker.book().genre());
        };
        List<Libri> libri = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            libri.add(booksSupplier.get());
        }
        libri.forEach(System.out::println);

        //Qui creiamo 100 riviste casuali
        Supplier<Riviste> RivisteSupplier = () -> {
            Faker faker = new Faker(Locale.ITALY);
            Random rndm = new Random();
            String[] randomPeriodicità = {Riviste.SETTIMANALE, Riviste.MENSILE, Riviste.SEMESTRALE};
            String periodicitàCasuale = randomPeriodicità[rndm.nextInt(3)];
            return new Riviste(rndm.nextInt(1000, 9900000), faker.lorem().word(), rndm.nextInt(2000, 2024), rndm.nextInt(0, 100), periodicitàCasuale);
        };
        List<Riviste> riviste = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            riviste.add(RivisteSupplier.get());
        }
        riviste.forEach(System.out::println);

        //Scanner per aggiunt e ricerca
        Scanner input = new Scanner(System.in);
        System.out.println("digita un numero:");
        String numero = input.nextLine();
        System.out.println("hai inserito: " + numero);
    }
}
