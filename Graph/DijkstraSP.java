package Graph;

import linear.Queue_ny;
import priority.IndexMinPriorityQueue;

//dijstra最短路径实现
public class DijkstraSP {
    private DirectedEdge[] edgeTo;//索引为顶点，值为从顶到到当前顶点的最短路径上的最后一条边
    private double[] distTo;//索引为顶点，值为顶点到当前顶点的最短路径的总权重
    private IndexMinPriorityQueue<Double> pq;//存放树中顶点与非树中顶点之间的有效横切边
    //根据加权有向图和顶点，创建一个计算顶点的最短路径树对象
    public DijkstraSP(EdgeWeightDigraph G,int s){
        this.edgeTo = new DirectedEdge[G.V()];
        this.distTo = new double[G.V()];
        this.pq = new IndexMinPriorityQueue<>(G.V());
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        //默认0号元素为树
        distTo[s]=0.0;
        pq.insert(s,0.0);
        while (!pq.isEmpty()){
            relax(G,pq.delMin());
        }
    }
    //松弛技术
    private void relax(EdgeWeightDigraph G,int v){
        //获取该点的邻接表中的边
        for (DirectedEdge edge : G.adj(v)) {
            int w = edge.to();//该边指向的另一个点
            //通过松弛技术，判断从起点s到顶点w的最短路径是否需要先从顶点s到顶点v，然后再由顶点v到顶点w
            if(distTo[v]+edge.weight()<distTo[w]){
                //更新
                distTo[w]=distTo[v]+edge.weight();
                edgeTo[w]=edge;
                if(pq.contains(w)){
                    //存在则更新
                    pq.changeItem(w,distTo[w]);
                }else {
                    pq.insert(w,distTo[w]);
                }
            }
        }
    }
    //获取总权重
    public double distTo(int v){
        return distTo[v];
    }
    //是否可达
    public boolean hasPathTo(int v){
        return distTo[v]<Double.POSITIVE_INFINITY;
    }
    //查询起点到顶点的最短路径
    public Queue_ny<DirectedEdge> pathTo(int v){
        //如果不存在到该点的边
        if(!hasPathTo(v)){
            return null;
        }
        Queue_ny<DirectedEdge> edges = new Queue_ny<>();
        while (true){
            DirectedEdge e = edgeTo[v];//上一条边
            if(e==null){
                break;
            }
            edges.enqueue(e);
            v=e.from();
        }
        return edges;
    }
}
