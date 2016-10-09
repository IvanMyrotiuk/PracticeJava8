package com.java.myrotiuk;

import com.java.myrotiuk.j8.Converter;
import com.java.myrotiuk.j8.Formula;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        Formula formula = new Formula() {
//            @Override
//            public double calculate(int a) {
//                return sqrt(100 * a);
//            }
//        };

        Formula formula = (a) -> a;//sqrt(100 * a);// we cannot refer to sqrt method outside scope

        System.out.println(formula.calculate(200));
        System.out.println(formula.sqrt(16));

        List<String> names = Arrays.asList("Lilu", "Abba", "Boby", "Zina", "Dianna", "John", "Liza", "Kate");

        Collections.sort(names, (a, b) -> a.compareTo(b));
        System.out.println("names" + names);

        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Converter<String, Integer> converter2 = Integer::valueOf;
        System.out.println("converter = " + converter.convert("77"));
        System.out.println("converter2 = " + converter2.convert("17"));

        Something smth = new Something();

        Converter<String, String> converter3 = smth::startWith;

        String resultOfSmth = converter3.convert("Java");
        System.out.println("resultOfSmth = " + resultOfSmth);
    }
}
