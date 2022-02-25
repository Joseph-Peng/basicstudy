import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, Node> map;
    DoubleList cache;
    int capacity;

    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        cache.remove(node);
        cache.addFirst(node);
        return node.value;
    }

    public void put(int key, int value){
        Node node = new Node(key, value);
        if (map.containsKey(key)){
            cache.remove(map.get(key));
            cache.addFirst(node);
            map.put(key,node);
        }else {
            if (map.size() == capacity){
                int k = cache.removeLast();
                map.remove(k);
            }
            cache.addFirst(node);
            map.put(key,node);
        }
    }


    class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node(){}

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    class DoubleList{
        Node head;
        Node tail;
        int size;

        public DoubleList(){
            head = new Node();
            tail = new Node();

            head.next = tail;
            tail.pre = head;
        }

        public void addFirst(Node node){
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
        }

        public int remove(Node node){
            int key = node.key;
            node.pre.next = node.next;
            node.next.pre = node.pre;
            return key;
        }

        public int removeLast(){
            if (head.next == tail){
                return -1;
            }
            return remove(tail.pre);
        }
    }
}
