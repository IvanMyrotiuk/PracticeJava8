package com.java.myrotiuk.j8;

/**
 * Created by Ivan on 03.10.2016. All rights reserved.
 */
public interface Formula {

    double calculate(int a);

    default double sqrt(int a){
        return Math.sqrt(a);
    }
}
