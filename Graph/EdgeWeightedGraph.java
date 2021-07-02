package Graph;

import linear.Queue_ny;

//加权无向图实现
public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private Queue_ny<Edge>[] adj;//邻接表中存储边

    public EdgeWeightedGraph(int v){
        this.V=v;
        this.E=0;
        this.adj=new Queue_ny[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue_ny<Edge>();
        }
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public void addEdge(Edge e){
        E++;
        int v = e.either();
        int w = e.other(v);
        adj[v].enqueue(e);
        adj[w].enqueue(e);
    }
    public Queue_ny<Edge> adj(int v){
        return adj[v];
    }
    //获取所有的边
    public Queue_ny<Edge> edges(){
        Queue_ny<Edge> edges = new Queue_ny<>();
        for (int i = 0; i < V; i++) {
            for (Edge e : adj[i]) {
                if(e.other(i)<i){
                    edges.enqueue(e);
                }
            }
        }
        return edges;
    }




}
