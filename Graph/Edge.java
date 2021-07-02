package Graph;
//加权边的表示
public class Edge implements Comparable<Edge>{
    private final int V;
    private final int W;
    private final double WEIGHT;

    public Edge(int v,int w,double weight){
        this.V = v;
        this.W = w;
        this.WEIGHT = weight;
    }
    public double weight(){
        return WEIGHT;
    }
    //获取边上的一个顶点
    public int either(){
        return V;
    }
    //获取vertex的另外一个顶点
    public int other(int vertex){
        if(vertex==V){
            return W;
        }
        return V;
    }


    @Override
    public int compareTo(Edge that) {
        int cmp;
        if(this.weight()>that.weight()){
            cmp=1;
        }else if(this.weight()<that.weight()){
            cmp=-1;
        }else {
            cmp=0;
        }
        return cmp;
    }
}
