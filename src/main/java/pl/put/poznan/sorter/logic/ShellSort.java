package pl.put.poznan.sorter.logic;

import org.springframework.stereotype.Service;
import pl.put.poznan.sorter.enums.SortingMethodEnum;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class ShellSort implements Sorting{
    // Insertion sort on sublist of every n-th element (e.g. second)
    // Moving elements that are far from where they should be is more effective
    @Override
    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> arr, boolean asc, int maxIterations) {
        int size = arr.size();
        if (maxIterations <= 0) maxIterations = Integer.MAX_VALUE;
        int iterations = 0;
        // Using knuth gap sequence
        int gap = 1;
        while (gap < size / 3){
            gap = 3 * gap + 1;
        }
        while (gap > 0){
            for (int i = gap; i < size; i++) {
                for (int j = i; j >= gap && iterations < maxIterations; j -= gap) {
                    if ((asc && arr.get(j-gap).compareTo(arr.get(j)) > 0) || (!asc && arr.get(j-gap).compareTo(arr.get(j)) < 0)) {
                        Collections.swap(arr, j, j-gap);
                    } iterations++;
                }
            }
            gap /= 3;
        }
        return arr;
    }

    @Override
    public SortingMethodEnum getSortingMethod() {
        return SortingMethodEnum.SHELL;
    }
}
