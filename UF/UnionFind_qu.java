package UF;
//并查集--quick_union实现
public class UnionFind_qu {
    private int[] id;
    private int count;
    public UnionFind_qu(int N){
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
        while (k!=id[k]){
            k=id[k];
        }
        return k;
    }
    public void union(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot==qRoot) return;
        //将p根变为q子
        id[pRoot]=qRoot;
        count--;
    }
}
