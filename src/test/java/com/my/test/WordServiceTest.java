package com.my.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordServiceTest {

    private final WordService wordService = new WordService();

    @Test
    public void findLongestWord() throws WordException {
        assertEquals("jumped", wordService.findLongestWord("The cow jumped over the moon."));
    }

    @Test
    public void findShortestWord() throws WordException {
        assertEquals("a", wordService.findShortestWord("The is a cow."));
    }

    @Test
    public void findLongestWordCanHandleMultipleSpaces() throws WordException {
        assertEquals("jumped", wordService.findLongestWord("The cow       jumped over       the      moon ."));
    }

    @Test
    public void findShortestWordCanHandleMultipleSpaces() throws WordException {
        assertEquals("a", wordService.findShortestWord("The     is a        cow."));
    }

    @Test
    public void findShortestWordCanHandlePunctuation() throws WordException {
        assertEquals("a", wordService.findShortestWord("The is a cow . "));
    }

    @Test
    public void findLongestWordMoreThanOneMatchReturnsFirstMatch() throws WordException {
        assertEquals("violet", wordService.findLongestWord("The violet space ship landed moon."));
    }

    @Test
    public void findShortestWordMoreThanOneMatchReturnsFirstMatch() throws WordException {
        assertEquals("The", wordService.findShortestWord("The cow jumped over the moon."));
    }

    @Test
    public void findShortestWordWithBlankString() {
        Throwable exception = assertThrows(WordException.class, () -> wordService.findShortestWord(""));
        assertEquals(exception.getMessage(), "blank or null sentence not supported.");
    }

    @Test
    public void findShortestWordWithNullString() {
        Throwable exception = assertThrows(WordException.class, () -> wordService.findShortestWord(null));
        assertEquals(exception.getMessage(), "blank or null sentence not supported.");
    }

    @Test
    public void findLongestWordWithBlankString() {
        Throwable exception = assertThrows(WordException.class, () -> wordService.findLongestWord(""));
        assertEquals(exception.getMessage(), "blank or null sentence not supported.");
    }

    @Test
    public void findLongestWordWithNullString() {
        Throwable exception = assertThrows(WordException.class, () -> wordService.findLongestWord(null));
        assertEquals(exception.getMessage(), "blank or null sentence not supported.");
    }

    @Test
    public void findLongestWordCanHandlePunctuation() {
        Throwable exception = assertThrows(WordException.class, () -> wordService.findLongestWord(" . , % & 1 45 ;  ' "));
        assertEquals(exception.getMessage(), "no word found here, words are not £$%^&*(,  or numbers");
    }
}