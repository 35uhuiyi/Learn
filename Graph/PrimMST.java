package Graph;

import linear.Queue_ny;
import priority.IndexMinPriorityQueue;

//Prim算法实现最小生成树
public class PrimMST {
    private Edge[] edgeTo;//索引为顶点，值为顶点到最小生成树之间的最短边
    private double[] distTo;//索引为顶点，值为顶点到最小生成树之间的最短边的权重
    private boolean[] marked;//索引为顶点，如果已经在树中为true
    private IndexMinPriorityQueue<Double> pq;//存放树中顶点与非树中顶点之间的有效横切边
    public PrimMST(EdgeWeightedGraph G){
        this.edgeTo = new Edge[G.V()];
        this.distTo = new double[G.V()];
        this.marked = new boolean[G.V()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i]=Double.POSITIVE_INFINITY;//初始无限大
        }
        //默认第一个顶点进树
        distTo[0]=0.0;
        this.pq = new IndexMinPriorityQueue<>(G.V());
        pq.insert(0,0.0);
        while (!pq.isEmpty()){
            visit(G,pq.delMin());
        }
    }
    //将顶点v添加到最小生成树中，并更新数据
    private void visit(EdgeWeightedGraph G, int v){
        marked[v]=true;
        //更新数据
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            //判断另外一个点是否在树中
            if(marked[w]){
                continue;//已在树中，不做处理
            }
            if(e.weight()<distTo[w]){
                edgeTo[w]=e;
                distTo[w]=e.weight();
                if(pq.contains(w)){
                    pq.changeItem(w,e.weight());
                }else {
                    pq.insert(w,e.weight());
                }
            }
        }
    }
    //获取最小生成树的所有边
    public Queue_ny<Edge> edges(){
        //创建队列对象
        Queue_ny<Edge> allEdges = new Queue_ny<>();
        //遍历edgeTo数组，拿到每一条边，如果不为null，则添加到队列中
        for (int i = 0; i < edgeTo.length; i++) {
            if (edgeTo[i]!=null){
                allEdges.enqueue(edgeTo[i]);
            }
        }
        return allEdges;
    }
}
