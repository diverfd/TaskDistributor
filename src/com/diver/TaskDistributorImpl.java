package com.diver;

import java.util.*;

public class TaskDistributorImpl implements TaskDistributor {
    private final Set<String> tasks;
    private final Set<String> names;
    private final ShufflerProvider shuffler;

    public TaskDistributorImpl(Set<String> tasks, Set<String> names, ShufflerProvider shuffler) {
        this.tasks = tasks;
        this.names = names;
        this.shuffler = shuffler;
    }
    @Override
    public Map<String, Set<String>> distributeTasks() {
        checkForNullOrEmpty(tasks, names);
        checkThatTaskSizeIsNotLessThanNamesSize(tasks, names);

        Map<String, Set<String>> distributedTasks = new HashMap<String, Set<String>>();

        List<String> shuffledTasks = shuffler.getShuffledList(tasks);
        List<String> shuffledNames = shuffler.getShuffledList(names);

        int numberOfGivenTasks = 0;
        while (numberOfGivenTasks < shuffledTasks.size()) {
            for (String name : shuffledNames) {
                final String task = shuffledTasks.get(numberOfGivenTasks);
                Set<String> ownSet = distributedTasks.get(name);

                if (ownSet == null) {
                    ownSet = new HashSet<String>();
                    ownSet.add(task);
                    distributedTasks.put(name, ownSet);
                } else {
                    ownSet.add(task);
                    distributedTasks.put(name, ownSet);
                }

                ++numberOfGivenTasks;
                if (numberOfGivenTasks == shuffledTasks.size()) {
                    break;
                }
            }
        }
        return distributedTasks;
    }

    private void checkForNullOrEmpty(Set<String> tasks, Set<String> names) {
        if (tasks == null || tasks.isEmpty()) {
            throw new IllegalArgumentException("Tasks can not be null or empty");
        }
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("Names can not be null or empty");
        }
    }

    private void checkThatTaskSizeIsNotLessThanNamesSize(Set<String> tasks, Set<String> names) {
        if (names.size() > tasks.size()) {
            final String msg = String.format("\nTasks(%d) should be >= names(%d).\n" +
                    "Otherwise someone could become jobless.", tasks.size(), names.size());
            throw new IllegalStateException(msg);
        }
    }
}
