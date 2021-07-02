package JMM;

public class vo {
    static boolean r = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            while (r){

            }
        },"t2");

        t1.start();
        Thread.sleep(1000);
        r=false;


    }
}
