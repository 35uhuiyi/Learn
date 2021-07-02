package Graph;
//检测有向图中是否有环
public class DirectedCycle {
    private boolean[] marked;//当前顶点是否被搜索过
    private boolean hasCycle;
    private boolean[] onStack;//使用栈思想，记录顶点是否处于正在搜索的路径上



    public DirectedCycle(Digraph G) {
        this.marked = new boolean[G.V()];
        this.hasCycle = false;
        this.onStack = new boolean[G.V()];
        //对所有顶点进行搜索
        for (int i = 0; i < G.V(); i++) {
            if(!marked[i]){
                dfs(G,i);
            }
        }
    }
    private void dfs(Digraph G,int v){
        marked[v]=true;
        //进栈
        onStack[v]=true;
        //搜索
        for (Integer w : G.adj(v)) {
            if(!marked[w]){
               dfs(G,w);
            }
            if(onStack[w]){
                hasCycle=true;
                return;
            }
        }
        //退栈
        onStack[v]=false;
    }
    public boolean hasCycle(){
        return hasCycle;
    }
}
