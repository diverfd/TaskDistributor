package com.diver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class SimpleShuffler implements ShufflerProvider {
    @Override
    public List<String> getShuffledList(Set<String> setOfData) {
        List<String> listOfData = new ArrayList<>(setOfData);
        Collections.shuffle(listOfData);
        return listOfData;
    }
}
