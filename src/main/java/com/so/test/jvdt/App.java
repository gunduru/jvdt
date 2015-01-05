package com.so.test.jvdt;

import com.google.caliper.Benchmark;
import com.google.caliper.Param;

/**
 * Taken directly from the Caliper tutorial: The problem is that the Java
 * Virtual Machine is too smart: it detected the fact that the loop was
 * producing no actual result, so it simply compiled it right out. The method
 * never looped at all. To fix this, we need to use a dummy result value.
 */
public class App extends Benchmark {
    
    @Param int size; // set automatically by framework, provided in the Main

    /**
     * Variable is declared inside the loop.
     * 
     * @param reps
     * @return 
     */
    public double timeDeclaredInside(int reps) {
        /* dummy variable needed to workaround smart jvm */
        double dummy = 0;
        /* test loop */
        for (double i = 0; i <= size; i++) {
            /* declaration and assignment */
            double test = i;
            /* dummy assingment to fake jvm */
            if(i == size) {
                dummy = test;
            }
        }
        return dummy;
    }

    /**
     * Variable is declared before the loop.
     * 
     * @param reps
     * @return 
     */
    public double timeDeclaredBefore(int reps) {
        /* dummy variable needed to workaround smart jvm */
        double dummy = 0;
        /* actual test variable */
        double test = 0;
        /* test loop */
        for (double i = 0; i <= size; i++) {
            /* assignment */
            test = i;
            /* not actually needed here but we need consistant performance results */
            if(i == size) {
                dummy = test;
            }
        }
        return dummy;
    }

}
