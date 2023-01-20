package pl.put.poznan.sorter.logic;

import pl.put.poznan.sorter.enums.SortingMethodEnum;

import java.util.ArrayList;
//import java.util.Collections;

public class AutomaticChoice implements Sorting{
    /**
     * Method that chooses the best sorting method
     * @param arr Array to sort
     * @param asc Sorting direction
     * @param maxIterations Maximum number of iterations
     * @param <T> Type of elements in array
     * @return Sorted array
     */
    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> arr, boolean asc, int maxIterations) {
        int size = arr.size();
        float ascendention = 0;
        float continiuity = 0;
        int sign;
        int oldSign = 0;
        for (int i = 0; i < size; i++){
            sign= arr.get(i).compareTo(arr.get(i+1));
            if (sign < 0) ascendention++;
            if (oldSign == sign) continiuity++;
            oldSign = sign;
        }
        float pAscendention = ascendention / size;
        float pContiniuity = continiuity / size;
//        System.out.println("ascendention: " + pAscendention);
//        System.out.println("continuity: " + pContiniuity);
        if (pAscendention > 0.5 && pContiniuity > 0.5) {
            return new BubbleSort().sort(arr, asc, maxIterations);
        }
        else if (pAscendention > 0.5 && pContiniuity < 0.5) {
            return new InsertionSort().sort(arr, asc, maxIterations);
        }
        else if (pAscendention < 0.5 && pContiniuity > 0.5) {
            return new SelectionSort().sort(arr, asc, maxIterations);
        }
        else {
            return new HeapSort().sort(arr, asc, maxIterations);
        }
    }

    /**
     * Returns sorting method
     * @return Sorting method
     */
    @Override
    public SortingMethodEnum getSortingMethod() {return SortingMethodEnum.AUTOMATIC;}
}
