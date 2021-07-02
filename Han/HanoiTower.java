package Han;
//汉诺塔---分治思想（化繁为简）
public class HanoiTower {
    /**
     *
     * @param n 总盘子数
     * @param a 柱子A
     * @param b 柱子B
     * @param c 柱子C
     */
    private static void Tower(int n,char a,char b,char c){
        if(n==1){
            System.out.println("第1个盘子："+a+"->"+c);
        }else{
            //n>=2时，看作两组盘子，最下面一个为一组，上面n-1个为一组
            //1.把上面一组从a移动到b
            Tower(n-1,a,c,b);
            //2.把下面一组从a移动到c
            System.out.println("第"+n+"个盘子："+a+"->"+c);
            //3.把上面一组盘子从b移动到c
            Tower(n-1,b,a,c);
        }
    }

    public static void main(String[] args) {
        Tower(3,'A','B','C');
    }
}
