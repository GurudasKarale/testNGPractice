package com.seleniumtestNG.testNGPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        List<Integer> aa = new ArrayList<Integer>();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for(int i=0;i<5;i++) {
        	aa.add(i);
        	hm.put(i, (2*i));
        	
        };
        
        for(int e : aa) {
        	System.out.println(e);	
        }
        
        hm.forEach((x,y) -> { System.out.println(x+ "-->>" +y); });
    }
}
