package com.iralus.product.util;

public class EmptyChecker {
    public static boolean empty( final String s ) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }

    public static boolean empty( final Double d ) {
        // Null-safe, short-circuit evaluation.
        return d == null;
    }

    public static boolean empty( final Object o ) {
        // Null-safe, short-circuit evaluation.
        return o == null;
    }

}
