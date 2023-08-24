package DSA;
import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap<K,V> {
    int n;
    int N;
    LinkedList<Node> buckets[];
    class Node{
        K key;
        V value;
        Node(K key, V value){//java generics
            this.key=key;
            this.value=value;
        }
    }
    public HashMap(int N){
        this.N=N;
        this.n=0;
        buckets=new LinkedList[N];
        for(int i=0; i<buckets.length; i++){
            buckets[i]=new LinkedList<>();
        }
    }
    public int hash(K key){
        int x=key.hashCode();
        return Math.abs(x)%N;
    }
    public int findIdx(K key, int idx){
        LinkedList<Node> bucket=buckets[idx];
        for(int i=0; i<bucket.size(); i++){
            if(bucket.get(i).key==key){
                return i;
            }
        }
        return -1;

    }
    public void rehash(){
        LinkedList<Node> temp[]=buckets;
        N*=2;
        n=0;//put function will increament n and bring it back to original
        buckets=new LinkedList[N];
        for(int i=0; i<buckets.length; i++){
            buckets[i]=new LinkedList<>();
        }
        for(int i=0; i<temp.length; i++){
            for(int j=0; j<temp[i].size(); j++){
                Node curr=temp[i].get(j);
                put(curr.key, curr.value);
            }
        }

    }
    public void put(K key, V value){
        Node newNode=new Node(key, value);
        int bucketIdx=hash(key);
        int listIdx=findIdx(key,bucketIdx);
        if(listIdx==-1){
            buckets[bucketIdx].add(new Node(key, value));
            n++;
        }else{
            buckets[bucketIdx].get(listIdx).value=value;
        }
        double lambda=(double)n/N;
        if(lambda>2.0){
            rehash();
        }
    }
    public int size(){
        return n;
    }
    public boolean containsKey(K key){
        int bucketIdx=hash(key);
        return findIdx(key, bucketIdx)!=-1;
    }
    public V get(K key){
        int bucketIdx=hash(key);
        int idx=findIdx(key, bucketIdx);
        if(idx==-1){
            return null;
        }
        return buckets[bucketIdx].get(idx).value;
    }
    public V remove(K key){
        if(!containsKey(key)){
            return null;
        }
        int bucketIdx=hash(key);
        int idx=findIdx(key, bucketIdx);
        Node removedNode=buckets[bucketIdx].remove(idx);
        n--;
        return removedNode.value;
    }
    public ArrayList<K> keySet(){
        ArrayList<K> keys=new ArrayList<>();
        for(int i=0; i<buckets.length; i++){
            for(int j=0; j<buckets[i].size(); j++){
                Node curr=buckets[i].get(j);
                keys.add(curr.key);
            }
        }
        return keys;
    }
    public boolean isEmpty(){
        return n==0;
    }
    
}
