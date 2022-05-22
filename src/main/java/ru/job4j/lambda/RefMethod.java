package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class RefMethod {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Ivan",
                "Petr Arsentev"
        );
        Consumer<String> out = RefMethod::cutOut;
        names.forEach(out);
    }

    public static void cutOut(String value) {
        Predicate<String> strPred = (str) -> str.length() > 10;
        Consumer<String> strCons = System.out::println;
        if (strPred.test(value)) {
            strCons.accept(value.substring(0, 10) + "..");
        } else {
            strCons.accept(value);
        }
    }
}
