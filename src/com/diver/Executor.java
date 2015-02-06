package com.diver;

import java.util.*;

public class Executor {

    public static void main(String[] args) {
        final Set<String> tasks = new HashSet<>(Arrays.asList("Prototype", "Builder", "Factory", "Abstract Factory", "Singleton"));
        final Set<String> names = new HashSet<>(Arrays.asList("Denis", "Pasha", "Stepa"));

        final ShufflerProvider simpleShuffler = new SimpleShuffler();
        TaskDistributor distributor = new TaskDistributorImpl(tasks, names, simpleShuffler);

        Map<String, Set<String>> distributedTasks = distributor.distributeTasks();
        System.out.println(distributedTasks);
    }

    private static Set<String> createTasks() {
        Set<String> tasks = new HashSet<String>();
        for (int taskNumber = 1; taskNumber < 11; taskNumber++) {
            tasks.add("Task_" + taskNumber);
        }
        return tasks;
    }


}
