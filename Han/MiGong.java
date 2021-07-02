package Han;
//小球走迷宫--（递归问题）
public class MiGong {
    public static void main(String[] args) {
        int[][] map = createMap();
        printMap(map);
        System.out.println("______________________");
        setWay(map,1,1);
        printMap(map);
    }
    //创建地图
    private static int[][] createMap(){
        int[][] map = new int[8][7];
        //外围设置墙
        for (int i = 0; i < 8; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }
        for (int i = 0; i < 7; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }
        map[3][1]=1;
        map[3][2]=1;
        return map;
    }

    /**
     *
     * @param map
     */
    private static void printMap(int[][] map){
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }

    /**
     *
     * @param map
     * @param i 起始位置
     * @param j
     * @return
     */
    private static boolean setWay(int[][] map,int i,int j){
        if(map[6][5]==2){
            return true;
        }else {
            if(map[i][j]==0){
                map[i][j]=2;//走过为2
                if(setWay(map,i+1,j)){
                    return true;
                }else if(setWay(map,i,j+1)){
                    return true;
                }else if(setWay(map,i-1,j)){
                    return true;
                }else if(setWay(map,i,j-1)){
                    return true;
                }else {
                    map[i][j]=3;//走不通为3
                    return false;
                }
            }else {//为1，2（已走过），3时都不行
                 return false;
            }
        }
    }
}
