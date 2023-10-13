package fabiomarras;

import com.github.javafaker.Faker;

import java.util.Locale;

public class ApplicationMain {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Faker faker = new Faker(Locale.ITALY);
        System.out.println(faker.internet().emailAddress());
    }
}
