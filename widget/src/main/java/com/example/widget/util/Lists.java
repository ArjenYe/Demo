package com.example.widget.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arjen
 */

public class Lists {
    public static <T> List<T> ensureNotNull(List<T> list) {
        return list != null ? list : Lists.newArrayList();
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }
}
