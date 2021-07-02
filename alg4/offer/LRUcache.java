package alg4.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yang
 * @version 1.0
 * @date 2021/5/25 22:28
 */
public class LRUcache {

    //定义双向链表的Node结构
    class LinkedNode{
        int key;
        int val;
        LinkedNode prev;
        LinkedNode next;
        LinkedNode(){};
        LinkedNode(int k, int v){
            this.key = k;
            this.val = v;
        }
    }
    //定义一些成员变量
    //Map通过key来快速定位Node位置
    Map<Integer, LinkedNode> map = new HashMap<>();
    int size;
    int capacity;
    LinkedNode dummyHead;
    LinkedNode dummyTail;

    public LRUcache(int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.dummyHead = new LinkedNode();
        this.dummyTail = new LinkedNode();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }


    //获取
    public int get(int key) {
        //从HashMap中定位节点
        LinkedNode node = map.get(key);
        if(node==null){
            return -1;
        }else{
            moveToHead(node);
            return node.val;
        }
    }

    //放入
    public void put(int key, int val){
        LinkedNode node = map.get(key);
        if(node==null){
            //第一次放
            LinkedNode newNode = new LinkedNode(key, val);
            insertToHead(newNode);
            map.put(key, newNode);
            this.size += 1;
            if(this.size > this.capacity){
                LinkedNode tailNode = deleteTail();
                //在hashmap中也要删除
                map.remove(tailNode.key);
                this.size -= 1;
            }
        }else{
            //已有该节点，替换
            node.val = val;
            moveToHead(node);
        }
    }

    //删除双向链表中的节点
    private void deleteNode(LinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //常用：节点移动到头部
    private void moveToHead(LinkedNode node){
        deleteNode(node);
        insertToHead(node);
    }

    //头部插入新节点
    private void insertToHead(LinkedNode node){
        //该节点发出的指向
        node.prev = this.dummyHead;
        node.next = this.dummyHead.next;
        //发出该节点的指向
        this.dummyHead.next.prev = node;
        this.dummyHead.next = node;
    }

    //尾部删除节点
    private LinkedNode deleteTail(){
        LinkedNode node = this.dummyTail.prev;
        deleteNode(node);
        return node;
    }

}
