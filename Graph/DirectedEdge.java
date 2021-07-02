package Graph;
//加权有向边的表示
public class DirectedEdge {
    private final int V;//起点
    private final int W;//终点
    private final double WEIGHT;
    public DirectedEdge(int v, int w, double weight) {
        V = v;
        W = w;
        this.WEIGHT = weight;
    }
    public double weight(){
        return WEIGHT;
    }
    public int from(){
        return V;
    }
    public int to(){
        return W;
    }



}
