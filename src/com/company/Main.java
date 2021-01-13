package com.company;

import java.io.IOException;
import java.util.logging.*;

class Calculator{
    /*
     *  Class serves for calculating and logging
     */

    private final static Logger logr = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static float addition_operation(float one, float two) {
        logr.log(Level.CONFIG, "one = " + one + " two = " + two);
        if (two == 0)
            logr.log(Level.WARNING, "two = " + two);
        float three = one + two;
        return three;
    }
}

public class Main extends Calculator {

    private final static Logger logr = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        LogManager.getLogManager().reset();
        logr.setLevel(Level.ALL);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);

        logr.addHandler(ch);

    // logging to file
        try {
            FileHandler fh = new FileHandler("log.yml");
            fh.setLevel(Level.WARNING);
            fh.setFormatter(new SimpleFormatter());
            logr.addHandler(fh);
        }
        catch (IOException e){
            logr.log(Level.SEVERE, "Logging to file does not work!", e);
        }

        for (int i = 0; i < 5; i++){
            try {
                logr.log(Level.INFO, "Result " + addition_operation(2, i));
            }
            catch (Exception e) {
                logr.log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }
}
