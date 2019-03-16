/**
 * Copyright (c) 2019 Jay C. Graham
 * Distributed under the MIT License (http://www.opensource.org/licenses/mit-license.php)
 */
package org.metable.math.polynomials;

public class PolynomialMathRecursive {
    
    public static double[] coefficients(final double[] constants) {
        double[] result = new double[constants.length + 1];

        result[0] = 1;

        coefficients(constants, 0, result);

        return result;
    }

    private static void coefficients(final double constant, final int index, final double[] result) {
        if (index == 0) {
            return;
        }

        result[index] = result[index - 1] + result[index] * constant;

        coefficients(constant, index - 1, result);
    }

    private static void coefficients(final double[] constants, final int index, final double[] result) {

        if (index == constants.length) {
            return;
        }

        final double constant = constants[index];

        coefficients(constant, index, result);

        result[0] = result[0] * constant;
        result[index + 1] = 1;

        coefficients(constants, index + 1, result);
    }
}
