package pl.put.poznan.sorter.logic;

import org.springframework.stereotype.Service;
import pl.put.poznan.sorter.enums.SortingMethodEnum;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class HeapSort implements Sorting{
    @Override
    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> arr, boolean asc) {
        int size = arr.size();
        System.out.print("Heap! ");
        for ( int i =size/2-1;i>=0;i--) {
            heap(arr, size, i, asc);
        }
        for (int i = size-1;i>0;i--){
            Collections.swap(arr, 0,i);
            heap(arr,i,0,asc);
        }
        return arr;
    }

    public <T extends Comparable<T>> void heap(ArrayList<T> arr,int size, int i,boolean asc){
        int maks=i, l=2*i+1, r=2*i+2;
        if (l<size && ((asc && arr.get(l).compareTo(arr.get(maks)) > 0) || (!asc && arr.get(l).compareTo(arr.get(maks)) < 0)))
            maks=l;
        if (r<size && ((asc && arr.get(r).compareTo(arr.get(maks)) > 0) || (!asc && arr.get(r).compareTo(arr.get(maks)) < 0)))
            maks=r;
        if (maks!=i){
            Collections.swap(arr, i,maks);
            heap(arr,size,maks,asc);
        }

    }

    @Override
    public SortingMethodEnum getSortingMethod() {
        return SortingMethodEnum.HEAP;
    }
}
