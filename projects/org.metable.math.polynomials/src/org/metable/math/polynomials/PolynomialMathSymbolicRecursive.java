/**
 * Copyright (c) 2019 Jay C. Graham
 * Distributed under the MIT License (http://www.opensource.org/licenses/mit-license.php)
 */
package org.metable.math.polynomials;

public class PolynomialMathSymbolicRecursive {

    private static final String ADD_OP = "+";
    private static final String MULT_OP = "";

    public static String[] coefficients(final String[] constants) {
        String[] result = new String[constants.length + 1];

        result[0] = "1";

        coefficients(constants, 0, result);

        return result;
    }

    private static void coefficients(final String constant, final int index, final String[] result) {
        if (index == 0) {
            return;
        }

        final String ri = result[index].equals("1") ? "" : result[index];

        result[index] = "(" + result[index - 1] + ADD_OP + ri + MULT_OP + constant + ")";

        coefficients(constant, index - 1, result);
    }

    private static void coefficients(final String[] constants, final int index, final String[] result) {

        if (index == constants.length) {
            return;
        }

        final String constant = constants[index];

        coefficients(constant, index, result);

        result[0] = (result[0].equals("1") ? "" : result[0]) + MULT_OP + constant;
        result[index + 1] = "1";

        coefficients(constants, index + 1, result);
    }
}
