package PortScanner;

public class MultiThreads implements Runnable {

    private int antalThreads = 1000;
    private int startPort;
    private int interval;
    private int antalporte = 65535;

    public MultiThreads() {
        interval = antalporte/antalThreads;
        startPort = 0;
    }

    @Override
    public void run() {
        System.out.println("Skanner");

        for (int threads = 0; threads < antalThreads; threads++) {
            ClientPortScanner portScanner = new ClientPortScanner(startPort, interval);
            Thread thread = new Thread(portScanner);
            thread.start();

            startPort += interval;
        }
    }
}
