package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.example.service.CalculatorService;

public class ParameterizedCalculatorTest {

    CalculatorService service=new CalculatorService();

    @ParameterizedTest
    @CsvSource({

            "2,3,5",
            "10,5,15",
            "20,30,50",
            "7,8,15"

    })

    void testAdd(int a,int b,int result){

        assertEquals(result,service.add(a,b));

    }

}