package Han;
//8皇后问题--（递归回溯问题）
public class EightQueen {
    private static int max = 8;
    private static int array[] = new int[max];
    private static int count = 0;
    private static int judgecount = 0;
    private static void print(){
        count++;
        for (int i : array) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    /**
     * 判断放置第n个皇后后，是否与前面的冲突
     * @param n
     * @return
     */
    private boolean judge(int n){
        judgecount++;
        for (int i = 0; i < n; i++) {
            //是否在同一列，同一斜线
            if(array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }
    /**
     * 放置第n个皇后，
     * @param n
     */
    private void check(int n){
        if(n==max){
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n]=i;
            if(judge(n)){//如果不冲突了则放下一个n+1，再进行判断，在放下一个,每层i++判断
                check(n+1);
            }
            //直到遇到冲突了，则退回到n,再加i,再进n+1,
            //当n+1,n+1...失败了，会逐层退回
        }
    }
    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.check(0);
        System.out.println("count:"+count);
        System.out.println("judgecount:"+judgecount);
    }
}
