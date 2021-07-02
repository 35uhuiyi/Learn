package Graph;

import linear.Stack;

//顶点排序
public class DepthFirstOrder {
    private boolean[] marked;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph G){
        this.marked=new boolean[G.V()];
        this.reversePost=new Stack<>();

        for (int i = 0; i < G.V(); i++) {
            if(!marked[i]){
                dfs(G,i);
            }
        }
    }
    private void dfs(Digraph G,int v){
        marked[v]=true;
        for (Integer w : G.adj(v)) {
            if(!marked[w]){
                dfs(G,w);
            }
        }
        reversePost.push(v);
    }
    public Stack<Integer> reversePost(){
        return reversePost;
    }



}
