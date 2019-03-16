/**
 * Copyright (c) 2019 Jay C. Graham
 * Distributed under the MIT License (http://www.opensource.org/licenses/mit-license.php)
 */
package org.metable.math.polynomials;

public class PolynomialMathSymbolic {

    private static final String ADD_OP = "+";
    private static final String MULT_OP = "";

    public static String[] coefficients(final String[] constants) {
        String[] result = new String[constants.length + 1];
        result[0] = "1";

        for (int i = 0; i < constants.length; ++i) {
            final String constant = constants[i];

            for (int j = i; j > 0; --j) {
                final String ri = result[j].equals("1") ? "" : result[j];
                result[j] = "(" + result[j - 1] + ADD_OP + ri + MULT_OP + constant + ")";
            }

            result[0] = (result[0].equals("1") ? "" : result[0]) + MULT_OP + constant;

            result[i + 1] = "1";
        }

        return result;
    }
}
