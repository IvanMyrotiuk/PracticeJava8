package com.java.myrotiuk.j8;

/**
 * Created by Ivan on 03.10.2016. All rights reserved.
 */
@FunctionalInterface
public interface Converter<F, T> {

    T convert(F from);
    default double get(){
        return 1.0;
    }
}
