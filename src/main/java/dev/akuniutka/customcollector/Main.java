package dev.akuniutka.customcollector;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    private static final Faker FAKER = new Faker();
    private static final String DELIMITER = "-------------------";
    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String city = FAKER.address().city();
            for (int j = 0; j < 3; j++) {
                data.add(city + "\n" + FAKER.name().firstName() + "\n" + FAKER.name().lastName());
            }
        }
        data.forEach(s -> System.out.println("{\n" + s + "\n}"));
        System.out.println(DELIMITER);
        Map<String, List<String>> processed;
//        processed = data.stream().collect(Collectors.groupingBy(
//                line -> line.split("\n")[0],
//                Collectors.toList()
//        ));
//        for (Map.Entry<String, List<String>> entry : processed.entrySet()) {
//            System.out.println(">>> " + entry.getKey());
//            for (String line : entry.getValue()) {
//                System.out.println("{\n" + line + "\n}");
//            }
//        }
        System.out.println(DELIMITER);
        processed = data.stream().collect(Collectors.groupingBy(
                line -> line.split("\n")[0],
                Collector.of(
                        ArrayList<String>::new,
                        List::add,
                        (left, right) -> {left.addAll(right); return left;}
                )
        ));
        for (Map.Entry<String, List<String>> entry : processed.entrySet()) {
            System.out.println(">>> " + entry.getKey());
            for (String line : entry.getValue()) {
                System.out.println("{\n" + line + "\n}");
            }
        }
        System.out.println(DELIMITER);
        data.stream().collect(Collectors.groupingBy(
                line -> line.split("\n")[0],
                Collector.of(
                        () -> new MyCity("Moscow"),
                        (city, line) -> city.addPerson(new MyPerson(line.split("\n")[1], line.split("\n")[2])),
                        MyCity::merge,
                        MyCity::print
                )
        ));

    }
}
