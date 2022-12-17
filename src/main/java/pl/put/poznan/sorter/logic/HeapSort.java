package pl.put.poznan.sorter.logic;

import org.springframework.stereotype.Service;
import pl.put.poznan.sorter.enums.SortingMethodEnum;

import java.util.ArrayList;

@Service
public class HeapSort implements Sorting{
    @Override
    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> arr, boolean asc) {
        System.out.print("Heap! ");
        return arr;
    }

    @Override
    public SortingMethodEnum getSortingMethod() {
        return SortingMethodEnum.HEAP;
    }
}
