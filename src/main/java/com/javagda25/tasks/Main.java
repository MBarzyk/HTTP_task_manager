package com.javagda25.tasks;

public class Main {
    public static void main(String[] args) {

        String uri = "http://192.168.110.34:8080/task";

        Manager manager = new Manager();


        manager.get(uri).forEach(System.out::println);

//        manager.delete(uri, 1);

        manager.post(uri);

        manager.get(uri).forEach(System.out::println);
    }
}