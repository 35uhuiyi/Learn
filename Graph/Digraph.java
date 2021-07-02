package Graph;
import linear.Queue_ny;
//有向图实现
public class Digraph {
    private final int V;//顶点数量
    private int E;//边的数量
    private Queue_ny<Integer>[] adj;//邻接表
    public Digraph(int v){
        this.V=v;
        this.E=0;
        this.adj=new Queue_ny[v];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue_ny<Integer>();
        }
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    //由v-->w的有向边
    public void addEdge(int v,int w){
        E++;
        adj[v].enqueue(w);
    }
    public Queue_ny<Integer> adj(int v){
        return adj[v];
    }
    private Digraph reverse(){
        //该图的反向图
        Digraph r = new Digraph(V);
        for(int v=0;v<V;v++){
            for (Integer w : adj[v]) {
                r.addEdge(w,v);
            }
        }
        return r;
    }
}
