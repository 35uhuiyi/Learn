package alg4.Leetcode.DFS;

import java.util.*;

/**
 * @author yang
 * @version 1.0
 * @date 2021/4/21 21:52
 */
public class permutation {

    private Set<String> list = new HashSet<>();
    public String[] f(String s) {
        char[] ch = s.toCharArray();
        boolean[] map = new boolean[s.length()];
        List<String> path = new ArrayList<>();
        dfs(ch,0,ch.length,path,map);
        String[] res = list.toArray(new String[list.size()]);
        return res;
    }


    private void dfs(char[] s,int depth,int len, List<String> path, boolean[] map){
        if(depth==len){
            list.add(String.join("", path));
        }
        for(int i=0;i<len;i++){
            if(!map[i]){
                path.add(String.valueOf(s[i]));
                map[i] = true;
                dfs(s,depth+1,len,path,map);
                map[i] = false;
                path.remove(path.size()-1);
            }
        }
    }

    public String[] bfs(String s) {
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(String.valueOf(s.charAt(0)));
        while (!queue.isEmpty()){
            //第一遍【a/...】
            //第二遍【ab,ba/...】
            //第三遍【aba,baa,abb,bab/...】
            //表明访问到了最后一层，从队列里全部取出进行去重
            if(queue.peek().length() == s.length()){
                set.addAll(queue);
                break;
            }
            String temp = queue.poll();
            int i = temp.length();
            for (int j = 0; j <= temp.length(); j++) {
                //在sb字符串的每个空隙j处插入新增加的字符charAt(i)，并入队
                StringBuilder sb = new StringBuilder(temp);
                sb.insert(j, s.charAt(i));
                queue.offer(sb.toString());
            }
        }
        return set.toArray(new String[0]);
    }


    public static void main(String[] args) {
        permutation permutation = new permutation();
        System.out.println(Arrays.toString(permutation.bfs("abb")));
    }
}
