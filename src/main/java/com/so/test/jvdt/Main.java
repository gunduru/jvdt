
package com.so.test.jvdt;

import com.google.caliper.runner.CaliperMain;

/**
 * Testing performance of declaring variables inside or outside a loop in Java.
 */
public class Main {

    public static void main(String[] args) {
        /* 100M loops */
        CaliperMain.main(App.class, new String[]{"-Dsize=100000000"});
    }
}
