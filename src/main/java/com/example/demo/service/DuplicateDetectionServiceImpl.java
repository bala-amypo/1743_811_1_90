package com.example.demo.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TextSimilarityUtil {
    public static double similarity(String s1, String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
            return 0.0;
        }
        Set<String> words1 = new HashSet<>(Arrays.asList(s1.toLowerCase().split("\\W+")));
        Set<String> words2 = new HashSet<>(Arrays.asList(s2.toLowerCase().split("\\W+")));
        Set<String> intersection = new HashSet<>(words1);
        intersection.retainAll(words2);
        Set<String> union = new HashSet<>(words1);
        union.addAll(words2);
        return (double) intersection.size() / union.size();
    }
}