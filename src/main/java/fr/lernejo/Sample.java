package fr.lernejo;

import java.util.function.BiFunction;

public class Sample {

    public int op(Operation op, int a, int b) {
        return op.func.apply(a, b);
    }

    enum Operation {
        ADD((a, b) -> a + b),DIVIDE((a, b) -> a / b),
        MULT((a, b) -> a * b),
        ;

        final BiFunction<Integer, Integer, Integer> func;

        Operation(BiFunction<Integer, Integer, Integer> func) {
            this.func = func;
        }
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 0)
            throw new DivisionByZeroException();
        return (new Sample()).op(Operation.DIVIDE, dividend, divisor);
    }
}
