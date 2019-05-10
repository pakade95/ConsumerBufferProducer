package Wersja_1;

public class Buffer {

    public int[] tab;
    private int liczbaElementowTablicy = 0;

    public Buffer(int tabSize) {
        this.tab = new int[tabSize];
    }

    public synchronized int get() {
        while (liczbaElementowTablicy == 0) {
            try {
                System.out.println("----Konsument zostal wstrzymany! " +
                        "W tym momencie bufor jest pusty!----");
                this.wait();
            } catch (InterruptedException e) {
                return 0;
            }
        }
        int element = tab[0];
        this.tab = removeFirst(tab);
        liczbaElementowTablicy--;
        this.notify();
        return element;
    }

    public synchronized void put(int element) {
        while (!(liczbaElementowTablicy < tab.length)) {
            System.out.println("----Producent został wstrzymany! " + "W tym momencie bufor jest przepełniony!----");
            try {
                this.wait();
            } catch (InterruptedException e) {
                return;
            }
        }
        this.tab[liczbaElementowTablicy] = element;
        System.out.println("Wyprodukowano element: " + element);
        liczbaElementowTablicy++;
        this.notify();
    }

    public int[] removeFirst(int[] tab) {
        int tab1[] = new int[tab.length];
        for (int i = 1; i < tab.length; i++) {
            tab1[i - 1] = tab[i];
        }
        return tab1;
    }

    public void print() {
        for (int i = 0; i < tab.length; i++) {
            System.out.println("Dodano do bufora: ");
        }
    }
}
