package com.example;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTesterTest {

    @Test
    void testPerformance() {

        PerformanceTester tester = new PerformanceTester();

        assertTimeout(Duration.ofSeconds(2), () -> {
            tester.performTask();
        });
    }
}