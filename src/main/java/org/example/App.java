package org.example;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Hello world!
 */
public class App {

    static final Thread thread = new Thread(new ContinuousConsoleOutput());

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World!");

        thread.start();
    }
}

class ContinuousConsoleOutput implements Runnable {

    @Override
    public void run() {

        final ResourceBundle.Control customControl = new CustomControl();
        int n = 0;

        while(true) {

            final ResourceBundle demoBundle = n < 20 ? ResourceBundle.getBundle("demo", customControl) : ResourceBundle.getBundle("demo");

            System.out.print(n++ + ":\t");
            System.out.println(demoBundle.getString("my.demo.key"));

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class CustomControl extends ResourceBundle.Control {
    @Override
    public long getTimeToLive(String baseName, Locale locale) {
        if (baseName == null || locale == null) {
            throw new NullPointerException();
        }
        return TTL_DONT_CACHE;
    }
}