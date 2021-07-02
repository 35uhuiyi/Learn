package Tree;

/**
 * @author yang
 * @version 1.0
 * @date 2021/4/16 14:30
 */
public class RBTree <K extends Comparable<K>, V>  {

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    //树根
    private RBNode root;

    public RBNode getRoot() {
        return root;
    }

    static class RBNode<K extends Comparable<K>, V>{
        private RBNode parent;
        private RBNode left;
        private RBNode right;
        private K key;
        private V value;
        private boolean color;
        public RBNode() {
        }

        public RBNode(RBNode parent, RBNode left, RBNode right, K key, V value, boolean color) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.key = key;
            this.value = value;
            this.color = color;
        }

        public RBNode getParent() {
            return parent;
        }

        public void setParent(RBNode parent) {
            this.parent = parent;
        }

        public RBNode getLeft() {
            return left;
        }

        public void setLeft(RBNode left) {
            this.left = left;
        }

        public RBNode getRight() {
            return right;
        }

        public void setRight(RBNode right) {
            this.right = right;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }
    }

    /**
     * 获取当前节点的父节点
     * @param node
     * @return
     */
    private RBNode parentOf(RBNode node){
        if(node==null) return null;
        if(node.parent!=null){
            return node.parent;
        }
        return null;
    }

    /**
     * 判断节点是否为红色
     * @param node
     * @return
     */
    private boolean isRed(RBNode node){
        if(node!=null){
            return node.color==RED;
        }
        return false;
    }

    /**
     * 判断节点是否为黑色
     * @param node
     * @return
     */
    private boolean isBlack(RBNode node){
        if(node!=null){
            return node.color==BLACK;
        }
        return false;
    }

    /**
     * 设置节点为红色
     * @param node
     */
    private void setRed(RBNode node){
        if(node!=null){
            node.color = RED;
        }
    }

    /**
     * 设置节点为黑色
     * @param node
     */
    private void setBlack(RBNode node){
        if(node!=null){
            node.color = BLACK;
        }
    }

    public void inOrderPrint(){
        inOrderPrint(this.root);
    }


    /**
     * 中序遍历打印
     * @param node
     */
    private void inOrderPrint(RBNode node){
        if(node!=null){
            inOrderPrint(node.left);
            System.out.println("key:" + node.key + ", value:" + node.value);
            inOrderPrint(node.right);
        }
    }

    /**
     *      p
     *      |
     *      x
     *     / \
     *    lx  y
     *       / \
     *      ly ry
     */
    /**
     * 左旋
     * @param x
     */
    public void leftRotate(RBNode x){
        //先把y取出
        RBNode y = x.right;
        //x右子节点变为y左子节点
        x.right = y.left;
        //y左子节点的父节点变为x
        if(y.left!=null){
            y.left.parent = x;
        }
        //将y与x的父节点产生关联
        if(x.parent!=null){
            y.parent = x.parent;
            if(x == x.parent.left){
                x.parent.left = y;
            }else{
                x.parent.right = y;
            }
        }else{
            //跟新root引用
            this.root = y;
            this.root.parent = null;
        }
        //更新x的父节点
        x.parent = y;
        y.left = x;
    }

    /**
     *      p
     *      |
     *      x
     *     / \
     *    y   rx
     *   / \
     *  ly ry
     */
    /**
     * 右旋
     * @param x
     */
    private void rightRotate(RBNode x){
        //暂存左子节点y
        RBNode y = x.left;
        //x与ry的关系
        x.left = y.right;
        if(y.right!=null){
            y.right.parent = x;
        }
        //p的关系
        if(x.parent!=null){
            y.parent = x.parent;
            if(x==x.parent.left){
                x.parent.left = y;
            }else{
                x.parent.right = y;
            }
        }else{
            this.root = y;
            this.root.parent = null;
        }
        //x与y的关系
        x.parent = y;
        y.right = x;
    }

    /**
     * 插入方法
     * @param key
     * @param value
     */
    public void insert(K key, V value){
        RBNode node = new RBNode();
        node.setKey(key);
        node.setValue(value);
        //新插入节点一定是红色
        node.setColor(RED);
        insert(node);
    }

    private void insert(RBNode node){
        //查找node的父节点
        RBNode parent = null;
        RBNode x = this.root;
        while(x !=null){
            parent = x;
            //>0 去右子树
            int cmp = node.key.compareTo(x.key);
            if(cmp>0){
                x = x.right;
            }else if(cmp==0){
                x.setValue(node.getValue());
                return;
            }else{
                x = x.left;
            }
        }
        node.parent = parent;

        if(parent!=null){
            //放在父节点的左边还是右边
            int cmp = node.key.compareTo(parent.key);
            if(cmp>0){
                //放在右边
                parent.right = node;
            }else{
                parent.left = node;
            }
        }else{
            //第一次插入
            this.root = node;
        }
        //平衡
        insertFixup(node);
    }
    /**
     * ①空树，节点染为黑色
     * ②Key存在，替换
     * ③插入节点父节点为黑色（或不存在），新插入为红色，黑高依旧，无需操作
     * ④插入节点父节点为红色：
     *     --父、叔双红：父叔都变黑，祖父变红。祖父变为当前节点，递归处理
     *     --父红，叔黑（或不存在）：
     *           --LL: 变色+右旋（父染黑，祖父染红，以祖父右旋,完成）
     *           --LR：左旋+LL（先以父左旋，得到LL,父为当前节点继续）
     *
     *           --RR: 变色+左旋（父染黑，祖父染红，以祖父左旋，完成）
     *           --RL: 右旋+RR（先以父右旋，得到RR,父为当前节点继续）
     */
    /**
     * 平衡化
     * @param node
     */
    private void insertFixup(RBNode node){
        this.root.setColor(BLACK);
        RBNode parent = parentOf(node);
        RBNode grandPatent = parentOf(parent);
        //④情景
        if(parent!=null && isRed(parent)){
            //如果父为红，则一定有祖父节点
            RBNode uncle = null;
            if(parent == grandPatent.left){
                //父为L
                uncle = grandPatent.right;
                if(uncle!=null && isRed(uncle)){
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(grandPatent);
                    insertFixup(grandPatent);
                    return;
                }
                //父红叔黑
                if(uncle==null || isBlack(uncle)){
                    //LL
                    if(node==parent.left){
                        setBlack(parent);
                        setRed(grandPatent);
                        rightRotate(grandPatent);
                        return;
                    }
                    //LR
                    if(node==parent.right){
                        leftRotate(parent);
                        insertFixup(parent);
                        return;
                    }
                }
            }else{
                //父为R
                uncle = grandPatent.left;
                if(uncle!=null && isRed(uncle)){
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(grandPatent);
                    insertFixup(grandPatent);
                    return;
                }
                //父红叔黑
                if(uncle==null || isBlack(uncle)){
                    //RR
                    if(node==parent.right){
                        setBlack(parent);
                        setRed(grandPatent);
                        leftRotate(grandPatent);
                        return;
                    }
                    //RL
                    if(node==parent.left){
                        rightRotate(parent);
                        insertFixup(parent);
                        return;
                    }
                }
            }
        }
    }


}
