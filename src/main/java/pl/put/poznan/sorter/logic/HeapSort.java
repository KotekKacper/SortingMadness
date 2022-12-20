package pl.put.poznan.sorter.logic;

import org.springframework.stereotype.Service;
import pl.put.poznan.sorter.enums.SortingMethodEnum;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class that represents a heap sort algorithm
 */
@Service
public class HeapSort implements Sorting{
    /**
     * Sorts an array using heap sort algorithm
     * @param arr Array to sort
     * @param asc Sorting direction
     * @param maxIterations Maximum number of iterations
     * @param <T> Type of elements in array
     * @return Sorted array
     */
    @Override
    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> arr, boolean asc, int maxIterations) {
        int size = arr.size();
        if (maxIterations <= 0) maxIterations = Integer.MAX_VALUE;
        for (int i = size/2 - 1; i >= 0 && maxIterations > 0; i--) {
            heap(arr, size, i, asc);
            maxIterations--;
        }
        for (int i = size - 1; i > 0 && maxIterations > 0; i--){
            Collections.swap(arr, 0 ,i);
            heap(arr, i, 0, asc);
            maxIterations--;
        }
        return arr;
    }

    /**
     * Builds a heap on a list
     * @param arr Array to sort
     * @param size  Size of array
     * @param i Index of element
     * @param asc Sorting direction
     * @param <T> Type of elements in array
     */
    public <T extends Comparable<T>> void heap(ArrayList<T> arr, int size, int i, boolean asc){
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
    /**
     * Returns sorting method
     * @return Sorting method
     */
    @Override
    public SortingMethodEnum getSortingMethod() {
        return SortingMethodEnum.HEAP;
    }
}
