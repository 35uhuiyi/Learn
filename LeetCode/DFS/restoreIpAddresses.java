package LeetCode.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yang
 * @version 1.0
 * @date 2021/4/26 20:37
 */
public class restoreIpAddresses {

    private List<String> res = new ArrayList<>();
    public List<String> f(String s) {
        if(s==null||s.length()==0) {
            return res;
        }
        int len = s.length();
        if(len<4||len>12){
            return res;
        }
        dfs(s,0,len,0,new ArrayList<>());
        return res;
    }

    /**
     *
     * @param s
     * @param depth 当前深度
     * @param len 原字符总长
     * @param cur 当前的处理位索引
     * @param path 路径整数
     */
    private void dfs(String s,int depth, int len,int cur, List<String> path){
        if(len==cur&&depth==4){
            res.add(String.join(",",path));
        }
        if((len-cur)<(4-depth)||(len-cur)>3*(4-depth)){
            return;
        }
        for (int i = 0; i < 3; i++) {
            if(cur+i>=len){
                break;
            }
            int num = judge(s,cur,cur+i);
            if(num!=-1){
                path.add(num+"");
                dfs(s,depth+1,len,cur+i+1,path);//处理下一位
                path.remove(path.size()-1);
            }
        }
    }

    /**
     * 判断截取字符串合法性
     * @param s
     * @param start 开始索引
     * @param end 结束索引
     * @return
     */
    private int judge(String s,int start, int end){
        if(end>start&&s.charAt(start)=='0'){
            return -1;
        }
        int res=0;
        for(int i=start;i<=end;i++){
            res = res * 10 + s.charAt(i)-'0';
        }
        if(res>255){
            return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        restoreIpAddresses restoreIpAddresses = new restoreIpAddresses();
        List<String> f = restoreIpAddresses.f("010010");
        System.out.println(Arrays.toString(f.toArray()));
    }
}
