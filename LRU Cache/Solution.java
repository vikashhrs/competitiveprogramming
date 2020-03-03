import java.io.*; 
import java.util.*;
class CacheNode<T, T>{
    T key;
    T value;
    CacheNode<T, T> next;
    CacheNode<T, T> previous;

    public CacheNode(T Tey, T value){
        this.key = Tey;
        this.value = value;
        this.next = null;
        this.previous = null;
    }
}

class Cache{
    private int size;
    private HashMap<T, CacheNode<T, T>> addressMap;
    private CacheNode<T, T> rear;
    private CacheNode<T, T> front;

    public Cache(int size){
        this.size = size;
        this.addressMap = new HashMap<T, CacheNode<T, T>>();
        this.rear = null;
        this.front = null;
    }

    public void setKey(T key, T value){
        CacheNode<T, T> inMap = this.addressMap.get(key);
        if(this.front == null){
            inMap = new CacheNode<T, T>(key, value);
            this.front = inMap;
        }else if(inMap != null){
            CacheNode<T, T> previous = inMap.previous;
            CacheNode<T, T> next = inMap.next;
            previous.next = next;
            CacheNode<T, T> tempNext = this.front.next;
            inMap.next = tempNext;
            inMap.previous = null;
            this.front = inMap;
        }
        this.addressMap.put(key, inMap);
    }

    public T getKey(T key){
        CacheNode<T, T> inMap = this.addresssMap.get(key);
        if(inMap != null){
            CacheNode<T, T> previous = inMap.previous;
            CacheNode<T, T> next = inMap.next;
            CacheNode<T, T> tempPrevious = this.rear.prev;
            previous.next = next;
            inMap.next = null;
            inMap.prev = this.rear;
            this.rear = inMap; 
            this.addressMap.put(key, inMap);
            return inMap.value;
        }
        return null;
    }

    public void displayCache(){
        CacheNode<T, T> temp = this.front;
        while(temp!= 0){
            System.out.println("Key = "+temp.key+" Value = "+temp.value);
            temp = temp.next;
        }
    }
}
public class Solution{

    public static void main(String args[]){
        Cache cache = new Cache(10);
        cache.setKey("a", "1");
    } 
}