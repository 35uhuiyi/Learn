package Graph;

import linear.Queue_ny;

//加权有向图的表示
public class EdgeWeightDigraph {
    private final int V;
    private int E;
    private Queue_ny<DirectedEdge>[] adj;//邻接表

    public EdgeWeightDigraph(int v){
        this.V = v;
        this.E = 0;
        this.adj = new Queue_ny[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue_ny<DirectedEdge>();
        }
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    //添加一条边
    public void addEdge(DirectedEdge e){
        E++;
        //只需要添加起点指向
        int v = e.from();
        adj[v].enqueue(e);
    }
    public Queue_ny<DirectedEdge> adj(int v){
        return adj[v];
    }
    //获取图中所有的边
    public Queue_ny<DirectedEdge> edges(){
        Queue_ny<DirectedEdge> edges = new Queue_ny<>();
        for (int i = 0; i < V; i++) {
            for (DirectedEdge edge : adj[i]) {
                edges.enqueue(edge);
            }
        }
        return edges;
    }


}
