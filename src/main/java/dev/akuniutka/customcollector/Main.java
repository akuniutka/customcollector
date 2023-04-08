package dev.akuniutka.customcollector;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Faker FAKER = new Faker();
    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String city = FAKER.address().cityName();
            for (int j = 0; j < 3; j++) {
                data.add(city + "\t" + FAKER.name().firstName() + "\t" + FAKER.name().lastName());
            }
        }
        System.out.println(data);
    }
}
