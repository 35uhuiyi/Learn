package Graph;

import UF.UF_Tree_Weighted;
import linear.Queue_ny;
import priority.MinPriorityQueue;

public class KruskalMST {
    private Queue_ny<Edge> mst;//保存最小生成树的所有边
    private UF_Tree_Weighted uf;//
    private MinPriorityQueue<Edge> pq;//存储树中所有的边，使用最小优先队列，按照权重进行排序

    public KruskalMST(EdgeWeightedGraph G){
        this.mst = new Queue_ny<Edge>();
        this.uf = new UF_Tree_Weighted(G.V());
        this.pq = new MinPriorityQueue<>(G.E()+1);//索引优先队列基于堆实现，少一个0号元素

        //所有的边放进pq
        for (Edge edge : G.edges()) {
            pq.insert(edge);
        }
        while (!pq.isEmpty()&&mst.size()<G.V()-1){
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);

            if(uf.connected(v,w)){
                continue;//已经在同一颗树中，不做处理
            }
            uf.union(v,w);
            mst.enqueue(e);
        }
    }
    public Queue_ny<Edge> edges(){
        return mst;
    }
}
