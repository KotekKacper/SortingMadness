package pl.put.poznan.sorter.logic;

import pl.put.poznan.sorter.enums.SortingMethodEnum;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort implements Sorting{
    @Override
    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> arr, boolean asc, int maxIterations) {
        int minimum;
        int size = arr.size();
        if (maxIterations <= 0) maxIterations = Integer.MAX_VALUE;
        int iterations = 0;
        for (int i = 0; i < size && iterations < maxIterations; i++){
            minimum = i;
            for (int j = i; j < size && iterations < maxIterations; j++){
                int comparisonResult = arr.get(j).compareTo(arr.get(minimum));
                if ((asc && comparisonResult < 0) || (!asc && comparisonResult > 0)) {
                    minimum = j;
                } iterations++;
            }
            Collections.swap(arr, minimum, i);
        }
        return arr;
    }

    @Override
    public SortingMethodEnum getSortingMethod() {return SortingMethodEnum.SELECTION;}
}
