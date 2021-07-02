package HashST;
//线性探测法
public class LinearProbingHashST<Key, Value> {
    private int N;
    private int M;
    private Key[] keys;
    private Value[] values;
    public LinearProbingHashST(int M){
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }
    private int hash(Key key){
        return (key.hashCode()&0x7fffffff)%M;
    }
    //扩容
    private void resize(int cap){
        LinearProbingHashST<Key,Value> t = new LinearProbingHashST<>(cap);
        for (int i = 0; i < M; i++) {
            if(keys[i]!=null){
                t.put(keys[i],values[i]);
            }
        }
        keys=t.keys;
        values=t.values;
        M=t.M;
    }
    public void put(Key key,Value value){
        if(N>=M/2) resize(2*M);
        int i;
        for(i=hash(key);keys[i]!=null;i=(i+1)%M){//从hash值开始向后找到一个空位
            if(keys[i].equals(key)){//键相同替换值
                values[i]=value;
                return;
            }
        }
        keys[i]=key;
        values[i]=value;
        N++;
    }
    //获取
    public Value get(Key key) {
        for(int i=hash(key);keys[i]!=null;i=(i+1)%M){//从hash值开始向后找到一个空位
            if(keys[i].equals(key)){//键相同替换值
                return values[i];
            }
        }
        return null;
    }
    //删除
    //被删除键后面的所有键值重新插入散列表
    public void delete(Key key){
        int i=hash(key);
        while (!key.equals(keys[i])){
            i=(i+1)%M;
        }
        keys[i]=null;
        values[i]=null;

        i=(i+1)%M;
        while (keys[i]!=null){
            //不为空则先删除，再重新插入
            Key key1 = keys[i];
            Value value = values[i];
            keys[i]=null;
            values[i]=null;
            N--;

            put(key1,value);
            i=(i+1)%M;//while继续找
        }
        N--;
        if(N>0&&N<=M/8) resize(M/2);

    }

}
