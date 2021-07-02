package Graph;

import linear.Queue_ny;

//广度优先搜索--bfs
public class BreadthFirstSearch {
    private boolean[] marked;
    private int count;
    private Queue_ny<Integer> waitSearch;//辅助队列，（层序遍历树中的辅助）


    public BreadthFirstSearch(Graph01 G,int s) {
        this.marked = new boolean[G.V()];
        this.count = 0;
        this.waitSearch = new Queue_ny<>();
        bfs(G,s);
    }
    private void bfs(Graph01 G, int v){
        //修改搜索状态
        marked[v]=true;
        //辅助队列
        waitSearch.enqueue(v);
        while (!waitSearch.isEmpty()){
            Integer wait = waitSearch.dequeue();
            for (Integer w : G.adj(wait)) {
                if(!marked[w]){
                    bfs(G,w);
                }
            }
        }
        count++;
    }
    public boolean marked(int w){
        return marked[w];
    }
    public int count(){
        return count;
    }
}

