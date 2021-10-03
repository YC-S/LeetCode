package leetcode500.P14_hybrid_data_structure.plan2;

import java.util.HashMap;
import java.util.HashSet;

public class P432_AllOOneDataStructure {
    HashMap<String,Node> map = new HashMap<>();
    static class Node{
        HashSet<String> set = new HashSet<>();
        Integer val;
        Node pre;
        Node next;
    }
    Node Head = new Node();
    Node Tail = new Node();
    public P432_AllOOneDataStructure() {
        Head.next = Tail;
        Head.val = 1; // head means val = 1, it's easier to initiate
        Tail.pre = Head;
    }

    public void inc(String key) {
        if(!map.containsKey(key)){
            Head.set.add(key);
            map.put(key,Head);
        }else{
            Node cur = map.get(key);
            int curVal = cur.val;
            cur.set.remove(key);
            // remove node contains no keys
            if(cur.set.size() == 0 && cur != Head){
                cur.pre.next = cur.next;
                cur.next.pre = cur.pre;
                cur = cur.pre;
            }
            // if node already exist
            if(cur.next != Tail && cur.next.val == curVal + 1){
                cur.next.set.add(key);
                map.put(key,cur.next);
            }else{ // insert a new node after it
                Node node = new Node();
                node.set.add(key);
                node.val = curVal + 1;
                insert(cur,node);
                map.put(key,node);
            }
        }
    }
    // symmetric as above
    public void dec(String key) {
        if(!map.containsKey(key)) return ;
        if(map.get(key) == Head){
            Head.set.remove(key);
            map.remove(key);
        }else{
            Node cur = map.get(key);
            int curVal = cur.val;
            cur.set.remove(key);
            if(cur.set.size() == 0){
                cur.pre.next = cur.next;
                cur.next.pre = cur.pre;
                cur = cur.next;
            }
            if(cur.pre.val == curVal - 1){
                cur.pre.set.add(key);
                map.put(key,cur.pre);
            }else{
                Node node = new Node();
                node.set.add(key);
                node.val = curVal - 1;
                insert(cur.pre,node);
                map.put(key,node);
            }
        }
    }

    private void insert(Node cur,Node node){
        cur.next.pre = node;
        node.next = cur.next;
        cur.next = node;
        node.pre = cur;
    }

    public String getMaxKey() {
        if(Tail.pre.set.size() == 0) return "";
        return Tail.pre.set.iterator().next();
    }

    public String getMinKey() {
        if(Head.set.size() != 0) return Head.set.iterator().next();
        if(Head.next.set.size() == 0) return "";
        return Head.next.set.iterator().next();
    }
}
