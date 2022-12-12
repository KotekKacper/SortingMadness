package pl.put.poznan.sorter.logic;

import org.springframework.stereotype.Service;
import pl.put.poznan.sorter.enums.SortingMethodEnum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Service
public class BubbleSort implements Sorting{

    @Override
    public <T extends Comparable<T>> void sort(ArrayList<T> arr, boolean asc) {
        int size = arr.size();
        System.out.print("Bubble! ");
        for (int i = 0; i < size-1; i++){
            for (int j = 0; j < size-i-1; j++) {
                if ((asc && arr.get(j).compareTo(arr.get(j + 1)) > 0) || (!asc && arr.get(j).compareTo(arr.get(j + 1)) < 0)) {
                    Collections.swap(arr, j, j + 1);
                }
            }
        }
        System.out.println(arr);
    }

    @Override
    public SortingMethodEnum getSortingMethod() {
        return SortingMethodEnum.BUBBLE;
    }
}
