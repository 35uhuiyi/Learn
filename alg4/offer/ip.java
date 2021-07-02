package alg4.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang
 * @version 1.0
 * @date 2021/7/1 20:41
 */
public class ip {

    ArrayList<String> res = new ArrayList<>();
    public ArrayList<String> restoreIpAddresses (String s) {
        int len = s.length();
        if(len==0 || len >12 || len < 4){
            return res;
        }
        dfs(s, len, 0,0,new ArrayList<>());
       // dfs2(s,0,len,0,new ArrayList<>());
        return res;
    }
    private void dfs(String s, int len, int depth, int cur, List<String> path){
        if(len==cur&&depth==4){
            res.add(String.join(".", path));
        }
        //剪枝
        if((len-cur)<(4-depth)||(len-cur)>(3*(4-depth))){
            return;
        }
        //当前位，当前位+下一位，再加下一位，三种情况
        for(int i=0;i<3;i++){
            if(cur+i>=len){
                break;
            }
            int num = judge(s, cur, i+cur);
            if(num!=-1){
                path.add(num+"");
                dfs(s,len,depth+1,cur+i+1,path);
                path.remove(path.size()-1);
            }
        }

    }

    void dfs2(String s,int depth, int len,int cur,List<String> path){
        if(len==cur&&depth==4){
            res.add(String.join(".", path));
        }
        //剪枝
        if((len-cur)<(4-depth)||(len-cur)>(3*(4-depth))){
            return;
        }
        for(int i=0;i<3;i++){
            if(cur+i>=len){
                break;
            }
            int num = judge(s,cur,cur+i);
            if(num!=-1){
                path.add(num+"");
                dfs2(s,depth+1,len,cur+i+1,path);
                path.remove(path.size()-1);
            }
        }

    }

    int judge(String s, int start, int end){
        if(end>start&&s.charAt(start)=='0'){  //两个0不能连在一起，但单独的0是可以的，要加上end>start  【0.0.0.0】
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
        ip ip = new ip();
        ArrayList<String> strings = ip.restoreIpAddresses("0000");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
