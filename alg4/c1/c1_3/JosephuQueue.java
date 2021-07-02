package alg4.c1.c1_3;

import linear.Queue_ny;

public class JosephuQueue {
    public static void main(String[] args) {
        int N=7;
        int M=2;
        Queue_ny<Integer> queue = new Queue_ny<>();
        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }
        while (!queue.isEmpty()){
            for (int i = 0; i < M-1; i++) {
                queue.enqueue(queue.dequeue());
            }
            System.out.println("del:"+queue.dequeue()+" ");
        }
    }
}
