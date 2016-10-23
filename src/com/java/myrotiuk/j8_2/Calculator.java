package com.java.myrotiuk.j8_2;

/**
 * Created by Ivan on 15.10.2016. All rights reserved.
 */
public interface Calculator {
    double calculate(Integer a);
    default double sqrt(Integer a){
        return Math.sqrt(a);
    }
}
