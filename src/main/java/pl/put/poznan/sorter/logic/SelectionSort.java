package pl.put.poznan.sorter.logic;

import pl.put.poznan.sorter.enums.SortingMethodEnum;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort implements Sorting{
    @Override
    public <T extends Comparable<T>> void sort(ArrayList<T> arr, boolean asc) {
        int minimum;
        int size = arr.size();
        System.out.print("Selection! ");

        for (int i = 0; i < size; i++){
            minimum = i;
            for (int j = i; j < size; j++){
                int comparisonResult = arr.get(j).compareTo(arr.get(minimum));
                if ((asc && comparisonResult < 0) || (!asc && comparisonResult > 0)) {
                    minimum = j;
                }
            }
            Collections.swap(arr, minimum, i);
        }
        System.out.println(arr);
    }

    @Override
    public SortingMethodEnum getSortingMethod() {return SortingMethodEnum.SELECTION;}
}
