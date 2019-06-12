package com.rjb888.week3App.songr;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class SongrController {

    @GetMapping("/home")
    public String getHelloWorld(){
        return "Hello World";
    }

    @GetMapping("/capitalize/{phrase}")
    public String capitalizePhrase(@PathVariable String phrase){
        return phrase.toUpperCase();
    }

    @GetMapping("/reverse")
    public String reversePhrase(@RequestParam String phrase){
        String[] arr = phrase.split(" ");
        List<String> arrList = Arrays.asList(arr);
        Collections.reverse(arrList);
        String output = "";
        for ( String word : arrList){
            output += word + " ";
        }
        return output;
    }

}
