package HeapSortPac;

import java.util.Collections;
import java.util.List;

/**
 * Created by seffrui on 16-3-28.
 */
public class HeapSortWithoutR {
    private static void BuildMaxHeap(List<Integer> datas) {
        int start = datas.size() / 2 - 1;
        for (int i = start; i >= 0; --i) {
            HeapModify(datas, i, datas.size());
        }
    }

    private static void HeapModify(List<Integer> datas, int i, int length) {
        while (true) {
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int largest = -1;
            if (l < length && datas.get(l) > datas.get(i))
                largest = l;
            else
                largest = i;
            if (r < length && datas.get(r) > datas.get(largest))
                largest = r;
            if (largest != i) {
                Collections.swap(datas, largest, i);
                i = largest;
            } else {
                break;
            }
        }
    }

    private static void HeapSort(List<Integer> datas) {
        BuildMaxHeap(datas);
        int length = datas.size();
        int tail = datas.size();
        for (int i = 0; i < length; ++i) {
            Collections.swap(datas, 0, tail - 1);
            HeapModify(datas, 0, tail - 1);
            --tail;
        }
    }

    public static void sort(List<Integer> datas) {
        HeapSort(datas);
    }
}
