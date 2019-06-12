package com.rjb888.week3App.songr;

import org.junit.Test;

import static org.junit.Assert.*;

public class SongrControllerTest {

    @Test
    public void test_getHelloWorld() {
        SongrController song = new SongrController();
        assertEquals("Route should return hello world",
                "Hello World",
                song.getHelloWorld());
    }

    @Test
    public void test_capitalizePhrase() {
        SongrController song = new SongrController();
        assertEquals("Capitalize functin should capitalize",
                "HELLO WORLD",
                song.capitalizePhrase("hello world"));
    }

    @Test
    public void test_reversePhrase(){
        SongrController song = new SongrController();
        assertEquals("Reverse function should return reversed string",
                "this is the correct order ",
                song.reversePhrase("order correct the is this"));
    }
}