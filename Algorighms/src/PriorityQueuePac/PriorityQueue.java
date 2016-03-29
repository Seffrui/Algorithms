package PriorityQueuePac;

import java.util.Collections;
import java.util.List;

/**
 * Created by seffrui on 16-3-29.
 */
public class PriorityQueue {
    public static void buildeMaxHeap(List<Integer> lists) {
        int start= lists.size()/2-1;
        for(int i=start;i>=0;--i){
            heapify(lists,i,lists.size());
        }
    }

    public static void heapify(List<Integer> list, int i, int length) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest=-1;
        largest=(left<length && list.get(left)>list.get(i))?left:i;
        if(right<length && list.get(right)>list.get(largest))
            largest=right;
        if(largest!=i){
            Collections.swap(list,i,largest);
            heapify(list,largest,length);
        }
    }

    public static void heapSort(List<Integer> list) {
        int length=list.size();
        int tail=length;
        buildeMaxHeap(list);
    }

    public static int maxNum(List<Integer> lists) {
        return lists.get(0);
    }

    public static int extractMax(List<Integer> lists) {
        Collections.swap(lists,0,lists.size()-1);
        int max=lists.remove(lists.size()-1);
        heapify(lists,0,lists.size());
        return max;
    }

    public static void increaceValue(List<Integer> lists, int i, int to) {
        lists.set(i,to);
        int parent=(i-1)/2;
        while(parent>=0 && lists.get(parent)<lists.get(i)){
            Collections.swap(lists,i,parent);
            i=parent;
            parent=(i-1)/2;
        }
    }

    public static void insert(List<Integer> lists, int key) {
        lists.add(-1);
        increaceValue(lists,lists.size()-1,key);
    }
}
