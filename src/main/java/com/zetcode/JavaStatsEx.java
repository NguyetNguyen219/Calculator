package com.zetcode;

import java.io.IOException;

/**
 * Starter class for MyStats application.
 *
 * @author janbodnar
 */

public class JavaStatsEx {

    /**
     * Application entry point.
     *
     * @param args application command line arguments
     */
    public static void main(String[] args) {

        var app = new MyStatsApp();
        try {
            app.run(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}