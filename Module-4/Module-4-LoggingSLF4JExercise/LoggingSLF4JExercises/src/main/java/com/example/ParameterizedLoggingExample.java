package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger =
            LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {

        String username = "John";

        int age = 25;

        logger.info("User {} has logged in.", username);

        logger.info("User {} is {} years old.", username, age);

        logger.debug("Debug: User = {}, Age = {}", username, age);

    }
}