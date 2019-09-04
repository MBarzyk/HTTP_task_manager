package com.javagda25.tasks;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String uri = "http://192.168.110.34:8080/task";

        String uriNew = "http://194.181.116.187:16666/task";
        Manager manager = new Manager();
        List<Task> taskList = new ArrayList<>();

          manager.get(uri).forEach(System.out::println);
    }

//        manager.put(uriNew);
//
//        manager.get(uriNew).forEach(System.out::println);
//
//        manager.delete(uriNew);
//
//        manager.get(uriNew).forEach(System.out::println);
//
//        manager.post(uriNew);
//
//        manager.get(uriNew).forEach(System.out::println);
}