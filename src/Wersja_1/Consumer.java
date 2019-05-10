package Wersja_1;

import java.util.Random;

public class Consumer extends Thread {

    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            Random random = new Random();
            System.out.println("Skonsumowano element: " + buffer.get());
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                return;
            }
        }
    }

}