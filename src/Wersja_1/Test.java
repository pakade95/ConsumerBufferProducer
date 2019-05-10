package Wersja_1;

public class Test {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(3);
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        producer.start();
        consumer.start();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producer.interrupt();
        consumer.interrupt();

        System.out.println("Koniec!");
    }
}
