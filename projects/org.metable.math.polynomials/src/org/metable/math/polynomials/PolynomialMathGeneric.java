/**
 * Copyright (c) 2019 Jay C. Graham
 * Distributed under the MIT License (http://www.opensource.org/licenses/mit-license.php)
 */
package org.metable.math.polynomials;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

public class PolynomialMathGeneric {

    // @formatter:off
    public static Double[] coefficients(Double[] constants) {
        return coefficients(
            constants,
            (length) -> { return new Double[length]; },
            ()       -> { return 1.0; },
            (x, y)   -> { return (x + y); },
            (x, y)   -> { return (x * y); }
        );
    }

    public static String[] coefficients(final String[] constants) {
        final String ADD_OP = "+";
        final String MULT_OP = "";

        return coefficients(
            constants,
            (length) -> { return new String[length]; },
            ()       -> { return "1"; },
            (x, y)   -> { return "(" + x + ADD_OP + y + ")"; },
            (x, y)   -> { return x + MULT_OP + y; }
        );
    }

    private static <T> T[] coefficients(
        final T[] constants,
        final Function<Integer, T[]> resultFactory,
        final Supplier<T> identity,
        final BinaryOperator<T> add,
        final BinaryOperator<T> mult)
    {
        T[] result = resultFactory.apply(constants.length + 1);
        result[0] = identity.get();

        for (int i = 0; i < constants.length; ++i) {
            final T constant = constants[i];

            for (int j = i; j > 0; --j) {
                result[j] = add.apply(result[j - 1], (mult.apply(result[j], constant)));
            }

            result[0] = mult.apply(result[0], constant);

            result[i + 1] = identity.get();
        }

        return result;
    }
    // @formatter:on
}
