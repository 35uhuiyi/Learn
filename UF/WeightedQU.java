package UF;
//加权quick_union算法
//小数加到大树上
public class WeightedQU {
    private int[] id;
    private int[] sz;
    private int count;
    public WeightedQU(int N){
        this.count=N;
        this.id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i]=i;
        }
        this.sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i]=i;
        }
    }
    public int count(){
        return count;
    }
    private boolean connected(int p,int q){
        return find(p)==find(q);
    }
    private int find(int k){
        while (true){
            if (k == id[k]){
                return k;
            }
            k = id[k];
        }
    }
    public void union(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot==qRoot) return;
        //小数加到大树上
        if(sz[pRoot]>id[qRoot]){
            id[qRoot]=pRoot;
            sz[pRoot]+=sz[qRoot];//原大小加上新小数的大小
        }else {
            id[pRoot]=qRoot;
            sz[qRoot]+=sz[pRoot];
        }
        count--;
    }
}
