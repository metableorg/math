/**
 * Copyright (c) 2019 Jay C. Graham
 * Distributed under the MIT License (http://www.opensource.org/licenses/mit-license.php)
 */
package org.metable.math.polynomials;

public class PolynomialMath {

    public static double[] coefficients(final double[] constants) {
        final double[] result = new double[constants.length + 1];
        result[0] = 1;

        for (int i = 0; i < constants.length; ++i) {
            final double constant = constants[i];

            for (int j = i; j > 0; --j) {
                result[j] = result[j - 1] + result[j] * constant;
            }

            result[0] = result[0] * constant;

            result[i + 1] = 1;
        }

        return result;
    }
}
