package Tree;
import linear.Queue_ny;
//折纸折痕问题
public class PaperFolding {
    private static class Node<T>{
        T item;
        Node left;
        Node right;
        private Node(T item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }
    //生成N层树
    private static Node<String> createTree(int N){
        Node<String> root = null;
        for (int i = 0; i < N; i++) {
            //第一次对折，创建root
            if(i==0){
                root = new Node<String>("down",null,null);
                continue;
            }
            //不是第一次对折
            //定义一个辅助队列，找到空叶子节点插入
            Queue_ny<Node> nodes = new Queue_ny<>();
            nodes.enqueue(root);
            while (!nodes.isEmpty()){
                Node n = nodes.dequeue();//此处表示队列操作中移除root
                if(n.left!=null){
                    nodes.enqueue(n.left);
                }
                if(n.right!=null){
                    nodes.enqueue(n.right);
                }
                if(n.left==null&&n.right==null){
                    Node<String> up = new Node<>("down", null, null);
                    Node<String> down = new Node<>("up", null, null);
                    //真正操作的地方
                    n.left=up;//在此处追加给了root
                    n.right=down;
                }
            }
        }
        return root;
    }
    //打印结果--中序
    private static void print(Node x){
        if(x==null){
            return;
        }
        if(x.left!=null){
            print(x.left);
        }
        System.out.print(x.item+" ");
        if(x.right!=null){
            print(x.right);
        }
    }

    public static void main(String[] args) {
        Node<String> tree = createTree(3);
        print(tree);

    }
}
