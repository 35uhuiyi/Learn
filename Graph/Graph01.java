package Graph;

import linear.Queue_ny;

//简单无向图
public class Graph01 {
    private final int V;//顶点
    private int E;//边
    private Queue_ny<Integer>[] adj;

    public Graph01(int v) {
        V = v;
        E = 0;
        this.adj = new Queue_ny[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i]= new Queue_ny<Integer>();
        }
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public void addEdge(int v,int w){
        adj[v].enqueue(w);
        adj[w].enqueue(v);
        E++;
    }
    public Queue_ny<Integer> adj(int v){
        return adj[v];
    }


}
