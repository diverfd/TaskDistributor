package com.diver;

import java.util.List;
import java.util.Set;

public interface ShufflerProvider {
    List<String> getShuffledList(Set<String> setOfData);
}
