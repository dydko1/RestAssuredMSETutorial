package com.dydko.winterbe.tut4;

import com.dydko.winterbe.tut2.Converter;
import org.testng.annotations.Test;

public class Lambda4 {

    static int outerStaticNum;
    int outerNum;

    @Test
    void testScope() {
        Converter<String, Integer> stringConverter = f -> {
            outerNum = 30;
            return Integer.valueOf(f);
        };

        Converter<String, Integer> stringIntegerConverter = f -> {
            outerStaticNum = 2344444;
            return Integer.valueOf(f);
        };
        System.out.println(stringConverter.converter("123"));
        System.out.println(outerNum);
        System.out.println(stringIntegerConverter.converter("23"));
        System.out.println(outerStaticNum);
    }
}
