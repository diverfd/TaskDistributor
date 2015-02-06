package com.diver;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        int[] randomNums = getArrayOfRandomNums(13, 100);
        for (int each : randomNums) {
            System.out.println(each);
        }
    }

    public static int[] getArrayOfRandomNums(int range, int amount) {
        int[] randomNums = new int[amount];
        NavigableMap<Long, Integer> original = generateNavigableMap(range);
        for (int index = 0; index < amount; index++) {
            randomNums[index] = getRandomNumber(original);
        }
        return randomNums;
    }

    private static NavigableMap<Long, Integer> generateNavigableMap(int size) {
        int fragmentSize = 100 / size;
        NavigableMap<Long, Integer> original = new TreeMap<Long, Integer>();
        original.put(0L, 1);
        long fragment = fragmentSize;
        for (int number = 2; number < size + 1; number++) {
            original.put(fragment, number);
            fragment += fragmentSize;
        }
        return original;
    }

    private static int getRandomNumber(NavigableMap<Long, Integer> map) {
        long timestamp = getModuloNanoTime();
        Map.Entry<Long, Integer> floorEntry = map.floorEntry(timestamp);
        Integer randomNumber = floorEntry.getValue();
        return randomNumber;
    }

    private static long getModuloNanoTime() {
        return System.nanoTime() % 100;
    }
}
