package com.example.demo.util;

import java.util.HashSet;
import java.util.Set;

public class TextSimilarityUtil {

    public static double similarity(String a, String b) {

        if (a == null || b == null) {
            return 0.0;
        }

        String[] wordsA = a.toLowerCase().split("\\W+");
        String[] wordsB = b.toLowerCase().split("\\W+");

        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();

        for (String w : wordsA) {
            if (!w.isBlank()) setA.add(w);
        }

        for (String w : wordsB) {
            if (!w.isBlank()) setB.add(w);
        }

        if (setA.isEmpty() && setB.isEmpty()) return 1.0;
        if (setA.isEmpty() || setB.isEmpty()) return 0.0;

        Set<String> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);

        Set<String> union = new HashSet<>(setA);
        union.addAll(setB);

        return (double) intersection.size() / union.size();
    }
}