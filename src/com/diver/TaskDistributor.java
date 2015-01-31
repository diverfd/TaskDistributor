package com.diver;

import java.util.Map;
import java.util.Set;

public interface TaskDistributor {
    Map<String, Set<String>> distributeTasks();
}
