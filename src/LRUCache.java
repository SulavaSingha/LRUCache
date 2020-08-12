import java.util.HashMap;

class Node<K,V>{
    K key;
    V val;
    Node head;
    Node prev;
    Node next;
    public Node(){

    }
    public void addNode(Node n){
       next=head.next;
      head.next=n;
      n.prev=head;
      n.next=next;


    }
    public void removeNode(Node n){
        next= n.next;
        prev=n.prev;
        prev.next=next;
        next.prev=prev;
    }
    public void moveToHead(Node n){
        removeNode(n);
        addNode(n);
    }
}
public class LRUCache {
    HashMap<Integer,Node> cache;
    int capacity=10;
    Node head;
    Node tail;
    public LRUCache(){
        cache= new HashMap<>();
         head =new Node();
         tail =new Node();
        head.next=tail;
        tail.prev=head;
    }
    public void put(Integer key,Node n){
        if(cache.containsKey(key)){
            Node node= cache.get(key);
            node.moveToHead(node);
        }
        else {
            if(cache.size()>=capacity){
                Node last=tail.prev;
                last.next=null;
            }
            n.addNode(n);
        }
    }
    public Node get(Integer key){
        if(cache.containsKey(key)){
            Node n= cache.get(key);
            return n;
        }
        return null;
    }
}
