package KHeapPac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by seffrui on 16-3-29.
 */
public class KHeap {
    private List<Integer> lists = new ArrayList<>();
    private int k;

    public KHeap(List<Integer> lists, int k) {
        this.k = k;
        createKHeap(lists);
    }

    private void heapify(int i, int length) {
        int right = (i + 1) * k;
        int left = right - k + 1;
        right=(right>=length)?length-1:right;
        int largest = i;
        for (int j = left; j <= right; ++j) {
            if (lists.get(largest) < lists.get(j)) {
                largest = j;
            }
        }
        if (largest != i) {
            Collections.swap(lists, i, largest);
            heapify(largest, length);
        }
    }

    private void increase(int i, int to) {
        int parent = (i - 1) / k;
        lists.set(i, to);
        while (parent >= 0 && lists.get(i) > lists.get(parent)) {
            Collections.swap(lists, i, parent);
            i = parent;
            parent = (i - 1) / k;
        }
    }

    private void createKHeap(List<Integer> data) {
        for (Integer t : data) {
            lists.add(-1);
            increase(lists.size() - 1, t);
        }
    }

    public int extractMax() {
        int max = lists.get(0);
        Collections.swap(lists, 0, lists.size() - 1);
        lists.remove(lists.size() - 1);
        heapify(0, lists.size());
        return max;
    }
}
