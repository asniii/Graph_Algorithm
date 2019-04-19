package hash.easy.q46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Sort elements by frequency | Set 4 (Efficient approach using hash)
 * Print the elements of an array in the decreasing frequency if 2 numbers have same frequency then print the one which came first.
 */
public class Solution {

    static class Node{
        int value ;
        int freq;

        public Node(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }
    }
    public static void main(String args[]){
        int a[] = { 2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8 };
        sortByFreq(a);

        for(int i = 0;i<a.length;i++){
            System.out.println(a[i]);
        }

    }

    public static void sortByFreq(int arr[]){
        HashMap<Integer,Integer> hashMap= new HashMap<>();

        for(int i = 0;i<arr.length;i++){
            if(hashMap.containsKey(arr[i])){
                hashMap.put(arr[i],hashMap.get(arr[i]) + 1);
            } else {
                hashMap.put(arr[i],1);
            }
        }

        ArrayList<Node> nodes = new ArrayList<>();

        Iterator<Integer> itr = hashMap.keySet().iterator();

        while(itr.hasNext()){
            Integer i = itr.next();
            nodes.add(new Node(i,hashMap.get(i)));
        }

        Collections.sort(nodes,(a,b)->{
            if(a.freq<b.freq || a.freq>b.freq){
                return b.freq - a.freq;
            } else {
                for(int i = 0;i<arr.length;i++){
                    if(arr[i] == a.value){
                        return -1;
                    }
                    if(arr[i] == b.value){
                        return 1;
                    }
                }
            }
            return -1;
        });

        Iterator<Node> nodeIterator = nodes.iterator();
        int k = 0;
        while(nodeIterator.hasNext()){
            Node n = nodeIterator.next();
            int value = n.value;
            int freq = n.freq;
            for(int j = 0;j<freq;j++){
                arr[k] = value;
                k++;
            }

        }

    }
}
