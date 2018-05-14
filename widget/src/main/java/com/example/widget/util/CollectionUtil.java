package com.example.widget.util;

import java.util.Collection;

/**
 * @author arjen
 */

public class CollectionUtil {
    public static <T> boolean isNullOrEmpty(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }
}
