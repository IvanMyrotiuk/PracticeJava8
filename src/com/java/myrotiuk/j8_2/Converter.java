package com.java.myrotiuk.j8_2;

/**
 * Created by Ivan on 15.10.2016. All rights reserved.
 */
public interface Converter<F,T> {

    T convert(F from);
}
