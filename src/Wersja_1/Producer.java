package Wersja_1;

import java.util.Random;

public class Producer extends Thread {

    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            buffer.put(random.nextInt(1000));
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
