package de.resolve.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * The idea I used is to reverse the operations, so instead of adding 0 or 4, I am removing it. Instead of divide by 2, I am multiplying by 2.
 *
 * @author Rafael 
 */
public class MinimumOperation {

    private static final int INITIAL_NUMBER = 4;
    private static final List<String> result = new ArrayList<>();

    private static void convert(int n) {
        int number = n;
        if(n == INITIAL_NUMBER) {
            printResult();
        } else {
            int lastDigit = n % 10;
            if(lastDigit == 4 || lastDigit == 0) {
                number = (n - (n % 10)) / 10;
                result.add(number + " adding " + lastDigit + " = " + n);
            } else {
                number = number * 2;
                result.add(number + " divided by 2 = " + n);
            }
            convert(number);
        }
    }

    private static void printResult() {
        for(int i = result.size() - 1; i >= 0; i--) {
            System.out.println(result.get(i));
        }
    }

    public static void main(String[] args) {
        int n = 567;
        System.out.println("Finding N = " + n + " / Starting with " + INITIAL_NUMBER);
        convert(n);
    }
}
