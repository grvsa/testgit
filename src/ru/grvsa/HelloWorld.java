package ru.grvsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Test git");
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8}));

        list.stream().forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------");
        list.stream().forEach(integer -> System.out.println(integer));

        System.out.println("--------------------------------------------------------------------");

        FuncInt inter = value -> value > 5;

        for (Integer integer : list) {
            if (inter.test(integer)) {
                System.out.println(integer);
            }
        }

        System.out.println("--------------------------------------------------------------------");

//        Predicate<Integer> pft = value -> value > 2;
//        list.removeIf(pft);
//
//        list.stream().forEach(System.out::println);


//        test(new AtomicInteger(2),4);

        Integer m = 0;
        for (Integer integer : list) {
            if (integer > m)
                m = integer;
        }

        System.out.println(list.stream().max(Integer::compareTo).get());

        String result = "";
        for (Integer integer : list) {
            result += integer + " ";
        }

        result += list.stream().map(String::valueOf).collect(Collectors.joining(" "));
        result = list.parallelStream().map(String::valueOf).collect(Collectors.joining(" "));

        System.out.println(result);
    }

    public static void test(AtomicInteger a, Integer b){
//        b = 1;
        a.set(2);
//      Должен быть final или effectivel final
        Runnable r = ()->{
//            b = 1;
            System.out.println(a);
            System.out.println(b);
        };

        new Thread(r).start();

//        Runnable r1 = new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        };
    }
}


