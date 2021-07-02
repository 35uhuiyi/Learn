package UF;
//并查集--quick_find实现
public class UnionFind_qf {
    private int[] id;
    private int count;
    public UnionFind_qf(int N){
        this.count=N;
        this.id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i]=i;
        }
    }
    public int count(){
        return count;
    }
    private boolean connected(int p,int q){
        return find(p)==find(q);
    }
    private int find(int k){
        return id[k];
    }
    public void union(int p,int q){
        if(connected(p,q)){//已联通不做处理
            return;
        }
        int pID = find(p);
        int qID = find(q);
        for (int i = 0; i < id.length; i++) {
            if(pID==qID){
                id[i]=qID;
            }
        }
        count--;
    }
}
