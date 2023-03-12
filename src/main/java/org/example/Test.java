package org.example;

import lombok.SneakyThrows;
import org.example.model.Item;
import org.example.model.Person;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) {
        Person person = Person.builder()
                .firstName("John")
                .lastName("DOE")
                .age(10)
                .build();
        person.firstName("Billel");
        person.lastName("KETROUCI");
        person.age(26);
        System.out.println(person);

        System.out.println("Test.java exists ? " + fileExists(Paths.get(
                "src/main/java/org/example/Test.java")));

        printItem("Xbox Series S", 299.99d); // Works normally
        printItem(null, 299.99d); // throws NPE because of @NonNull on attribute

        // @Slf4j to inject an instance of log on a class
        // @RequiredArgsConstructor to create constructor made of only final fields, useful for Dependency Injection
    }

    private static void printItem(String name, double value) {
        System.out.println(new Item(name, value));
    }

    @SneakyThrows // When we know that exceptions are never thrown, no need to try catch or throws
    private static boolean fileExists(Path path) {
        if (Files.exists(path)) return true;
        Files.writeString(path, "File just created !");
        return false;
    }
}
