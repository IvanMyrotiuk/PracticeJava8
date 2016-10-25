package com.java.myrotiuk;

import com.java.myrotiuk.j8_2.Calculator;
import com.java.myrotiuk.j8_2.Converter;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ivan on 15.10.2016. All rights reserved.
 */
public class Main2 {

    public static void main(String[] args) {
        Calculator calculatorSqrt = a -> Math.sqrt(a);
        Calculator calculatorDivBy2 = a -> a / 2.0;
        System.out.println(calculatorSqrt.calculate(4));
        System.out.println(calculatorSqrt.sqrt(16));
        System.out.println(calculatorDivBy2.calculate(8));

        Converter<String, Integer> converter = Integer::valueOf;
        Converter<String, Integer> converter1 = from -> Integer.valueOf(from);
        Letter letter = new Letter();
        Converter<String, String> converter2 = from -> {
            System.out.println(from);
            return letter.getFirstLeter(from);
        };
        Converter<String, String> converter4 = letter::getFirstLeter;

        System.out.println("converter = " + converter.convert("12"));
        System.out.println("converter1 = " + converter1.convert("17"));
        System.out.println("converter2 = " + converter2.convert("Java"));
        System.out.println("converter4 = " + converter4.convert("Java"));

        List<String> names = Arrays.asList("Lilu", "Zina", "Abba", "John", "Bella", "Suzi", "Lilu", "Dianna", "Zoi");
        Comparator<String> cNames = (n1, n2) -> n1.compareTo(n2);
        Collections.sort(names, cNames);
        System.out.println(names);

        int num = 3;
        Converter<Integer, String> converter3 = from -> String.valueOf(from + num);
        System.out.println("converter3 = " + converter3.convert(12));

        Optional<String> optional = Optional.of("bam");


        optional.isPresent();           // true
        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"

        Optional<String> op = Optional.ofNullable(null);
        System.out.println(op.isPresent());
        //System.out.println(op.get());
        System.out.println(op.orElse("John"));

        System.out.println("----------------------------------------Stream-------------------------------------");
        List<String> letters = Arrays.asList("ddd2", "aaa2", "bbb1", "aaa1", "bbb3", "ccc", "bbb2", "ddd1");

        System.out.println("=------Filter------=");
        letters
                .stream()
                .filter(l -> l.startsWith("a"))
                .forEach(System.out::println);

        System.out.println("=----------Sorted--------=");
        letters
                .stream()
                .sorted()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);

        System.out.println(" has not changed letters = " + letters);

        System.out.println("=----------MAp------------=");
        letters
                .stream()
                .sorted((a, b) -> b.compareTo(a))
                .filter(a -> a.startsWith("b"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("=-------------Matcher-----------=");
        boolean anyStartWithA = letters.stream().anyMatch(s -> s.startsWith("a"));
        System.out.println("anyStartWithA = " + anyStartWithA);

        boolean allStartWithA = letters.stream().allMatch(s -> s.startsWith("a"));
        System.out.println("allStartWithA = " + allStartWithA);

        boolean nonStartWithZ = letters.stream().noneMatch(s -> s.startsWith("z"));
        System.out.println("nonStartWithZ = " + nonStartWithZ);

        System.out.println("=-------------Count-----------=");
        long count = letters.stream().filter(s -> s.startsWith("a")).count();
        System.out.println("count =" + count);

        System.out.println("=------------Reducer----------------=");
        String resultReduced = letters.stream().sorted().re.reduce("John is the best: ", (result, elem) -> result + "#" + elem);
        System.out.println("resultReduced = "+resultReduced);

        System.out.println("=---Parallel Streams ---=");

        int max = 1000000;
        List<Integer> l = new ArrayList<>(max);
        for(int i = 0; i < max; i++){
            Random r = new Random();
            l.add(r.nextInt(max));
        }

        long start = System.nanoTime();
        long countResultTiming = l.stream().sorted().count();
        long end = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(end - start);
        System.out.println("countResultTiming = "+ countResultTiming+" resultTiming = "+ millis);

        long start2 = System.nanoTime();
        long countResultTiming2 = l.parallelStream().sorted().count();
        long end2 = System.nanoTime();
        long millis2 = TimeUnit.NANOSECONDS.toMillis(end2 - start2);
        System.out.println("countResultTiming2 = " + countResultTiming2 + " resultTiming2 = " + millis2);

        System.out.println("FFFFFFFFFFFFFFFFFFFFf");


        System.out.println("change commit1 at master in MAIN2");
        System.out.println("change commit1 at master in MAIN   MASTER");
        System.out.println("change commit2 at master in MAIN2");

    }
}
