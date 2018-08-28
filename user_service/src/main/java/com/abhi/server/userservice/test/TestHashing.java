package com.abhi.server.userservice.test;

import java.util.HashMap;
import java.util.Map;

public class TestHashing {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("abhi","Julka");
        System.out.println("abhi".hashCode());
        map.put("Abhi","Julka");
        System.out.println("Abhi".hashCode());

        map.forEach((s, s2) -> {
            System.out.println("Key : "+ s +" value : "+ s2);
        });

        Employee emp1 = new Employee(1234,"Abhishek");
        Employee emp2 = new Employee(2345,"Abhishek");
        System.out.println("hash code of emp1 "+ emp1.hashCode());
        System.out.println("hash code of emp2 "+ emp2.hashCode());

        System.out.println("Equals: "+ emp1.equals(emp2));

        Map<Employee, String> map2 = new HashMap<>();
        map2.put(emp1, "Julka");
        map2.put(emp2,"Gupta");

        map2.forEach((k, v) -> {
            System.out.println("Key : "+ k +" value : "+ v);
        });
    }
}

//Hashing:

/**
 *
 * HashFunction(Key) - 12345
 *
 *
 *
 *
 */