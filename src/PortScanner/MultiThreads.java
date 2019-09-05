package PortScanner;

public class MultiThreads implements Runnable {

    private int antalThreads = 1000;
    private int startPort;
    private int interval;
    private int antalporte = 65535;
    private Listener listener;

    public MultiThreads(Listener listener) {
        this.listener = listener;
        interval = antalporte/antalThreads;
        startPort = 0;
    }

    @Override
    public void run() {
        System.out.println("Skanner");

        for (int threads = 0; threads < antalThreads; threads++) {
            ClientPortScanner portScanner = new ClientPortScanner(startPort, interval, listener);
            Thread thread = new Thread(portScanner);
            thread.start();

            startPort += interval;
        }
    }
}
