package com.my.test;

import java.util.Arrays;
import java.util.Comparator;

public class WordService {

    public String findLongestWord(String sentence) throws WordException {
        String[] splitSentence = splitSentence(sentence);
        Arrays.sort(splitSentence, (o1, o2) -> o2.length() - o1.length());
        return splitSentence[0];
    }

    public String findShortestWord(String sentence) throws WordException {
        String[] splitSentence = splitSentence(sentence);
        Arrays.sort(splitSentence, Comparator.comparingInt(String::length));
        return splitSentence[0];
    }

    private String[] splitSentence(String sentence) throws WordException {
        if(sentence == null || sentence.isEmpty())
            throw new WordException("blank or null sentence not supported.");
        String[] split = sentence.replaceAll("\\s{2,}", " ")
                .replaceAll("[^a-zA-Z ]", "")
                .split(" ");
        if(split.length < 1)
            throw new WordException("no word found here, words are not £$%^&*(,  or numbers");
        return split;
    }
}
