import KHeapPac.KHeap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by seffrui on 16-3-28.
 */
public class Test {
    public static  void main(String argv[]){
        Random random=new Random();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<1000;++i){
            int a=Math.abs(random.nextInt() % 10);
            list.add(a);
        }

        System.out.println("After sort");
        KHeap heap=new KHeap(list,5);
        for(int i=0;i<1000;++i){
            System.out.println(heap.extractMax());
        }
    }
}
