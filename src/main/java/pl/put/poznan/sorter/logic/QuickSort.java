package pl.put.poznan.sorter.logic;

import org.springframework.stereotype.Service;
import pl.put.poznan.sorter.enums.SortingMethodEnum;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Class that represents a bubble sort algorithm
 */
@Service
public class QuickSort implements Sorting{
    /**
     * Sorts an array using quick sort algorithm
     * @param arr Array to sort
     * @param asc Sorting direction
     * @param maxIterations Maximum number of iterations
     * @param <T> Type of elements in array
     * @return Sorted array
     */
    @Override
    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> arr, boolean asc, int maxIterations) {
        if (maxIterations <= 0) maxIterations = Integer.MAX_VALUE;
        quick(arr, 0, arr.size() - 1, asc, maxIterations);
        return arr;
    }

    /**
     * Divides array into two parts and sorts them recursively
     * @param arr Array to sort
     * @param begin Beginning of array
     * @param end End of array
     * @param asc Sorting direction
     * @param iterations Maximum number of iterations
     * @param <T> Type of elements in array
     */
    public <T extends Comparable<T>> void quick(ArrayList<T> arr, int begin, int end, boolean asc, int iterations) {
        if (iterations == 0) return;
        int i = begin, j = end;
        T pivot = arr.get(begin + (end - begin) / 2);
        while (i <= j){
            if (asc){
                while(arr.get(i).compareTo(pivot) < 0) i++;
                while(arr.get(j).compareTo(pivot) > 0) j--;
            }else{
                while(arr.get(i).compareTo(pivot) > 0) i++;
                while(arr.get(j).compareTo(pivot) < 0) j--;
            }
            if (i <= j) Collections.swap(arr, i++, j--);
        }
        if (i < end) quick(arr, i, end, asc, --iterations);
        if (begin < j) quick(arr, begin, j, asc, --iterations);
    }

    /**
     * Returns sorting method
     * @return Sorting method
     */
    @Override
    public SortingMethodEnum getSortingMethod() {
        return SortingMethodEnum.QUICK;
    }
}
