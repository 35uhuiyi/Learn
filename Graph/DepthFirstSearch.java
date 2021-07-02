package Graph;
//dfs深度优先搜索
public class DepthFirstSearch {
    private boolean[] marked;//索引为顶点，值为该点是否已被搜索
    private int count;
    //找出G中与v点通的顶点
    public DepthFirstSearch(Graph01 G,int v) {

        this.marked=new boolean[G.V()];
        this.count=0;
        dfs(G,v);
    }
    private void dfs(Graph01 G,int v){
        marked[v]=true;
        for (Integer integer : G.adj(v)) {
            if(!marked[integer]){
                dfs(G,integer);
            }
        }
        count++;
    }
    public boolean marked(int w){
        return marked[w];
    }
    public int count(){
        return count;
    }
}
