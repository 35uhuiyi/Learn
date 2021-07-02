package JMM;


public class sycn {
    static Integer i=0;
    static Object o = new Object();
    static Object o2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int m = 0; m < 50000; m++) {
                synchronized (o) {
                    i++;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int m = 0; m < 50000; m++) {
                synchronized (o) {
                    i--;
                }
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(i);
    }

}
