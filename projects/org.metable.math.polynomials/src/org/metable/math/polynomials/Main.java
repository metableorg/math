/**
 * Copyright (c) 2019 Jay C. Graham
 * Distributed under the MIT License (http://www.opensource.org/licenses/mit-license.php)
 */
package org.metable.math.polynomials;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        symbolicRecursive();
        symbolic();
    }

    private static void symbolic() {
        // Degree = 1.
        String[] constants = new String[] { "a" };
        String[] result = PolynomialMathSymbolic.coefficients(constants);

        System.out.println(Arrays.stream(result).collect(Collectors.joining(", ")));

        // Degree = 2.
        constants = new String[] { "a", "b" };
        result = PolynomialMathSymbolic.coefficients(constants);

        System.out.println(Arrays.stream(result).collect(Collectors.joining(", ")));

        // Degree = 3.
        constants = new String[] { "a", "b", "c" };
        result = PolynomialMathSymbolic.coefficients(constants);

        System.out.println(Arrays.stream(result).collect(Collectors.joining(", ")));

        // Degree = 4.
        constants = new String[] { "a", "b", "c", "d" };
        result = PolynomialMathSymbolic.coefficients(constants);

        System.out.println(Arrays.stream(result).collect(Collectors.joining(", ")));
    }

    private static void symbolicRecursive() {
        // Degree = 1.
        String[] constants = new String[] { "a" };
        String[] result = PolynomialMathSymbolicRecursive.coefficients(constants);

        System.out.println(Arrays.stream(result).collect(Collectors.joining(", ")));

        // Degree = 2.
        constants = new String[] { "a", "b" };
        result = PolynomialMathSymbolicRecursive.coefficients(constants);

        System.out.println(Arrays.stream(result).collect(Collectors.joining(", ")));

        // Degree = 3.
        constants = new String[] { "a", "b", "c" };
        result = PolynomialMathSymbolicRecursive.coefficients(constants);

        System.out.println(Arrays.stream(result).collect(Collectors.joining(", ")));

        // Degree = 4.
        constants = new String[] { "a", "b", "c", "d" };
        result = PolynomialMathSymbolicRecursive.coefficients(constants);

        System.out.println(Arrays.stream(result).collect(Collectors.joining(", ")));
    }
}
