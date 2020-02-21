package com.kodilla.exception.main;

import com.kodilla.exception.test.FirstChallenge;

public class ExceptionModuleRunner {

    public static void main(String[] args) {

        try {
            FirstChallenge firstChallenge = new FirstChallenge();
            double result = firstChallenge.divide(3, 0);
            System.out.println(result);

        } catch (ArithmeticException e) {
            System.out.println("Not dividing by zero!");
        }
    }
}