package pl.put.poznan.sorter.logic;

import org.springframework.stereotype.Service;
import pl.put.poznan.sorter.enums.SortingMethodEnum;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class BubbleSort implements Sorting{
    @Override
    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> arr, boolean asc, int maxIterations) {
        int size = arr.size();
        if (maxIterations <= 0) maxIterations = Integer.MAX_VALUE;
        int iterations = 0;
        for (int i = 0; i < size-1; i++){
            for (int j = 0; j < size-i-1 && iterations < maxIterations; j++) {
                if ((asc && arr.get(j).compareTo(arr.get(j + 1)) > 0) || (!asc && arr.get(j).compareTo(arr.get(j + 1)) < 0)) {
                    Collections.swap(arr, j, j + 1);
                } iterations++;
            }
        }
        return arr;
    }

    @Override
    public SortingMethodEnum getSortingMethod() {
        return SortingMethodEnum.BUBBLE;
    }
}
