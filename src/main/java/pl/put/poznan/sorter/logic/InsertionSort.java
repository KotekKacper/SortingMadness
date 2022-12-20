package pl.put.poznan.sorter.logic;

import org.springframework.stereotype.Service;
import pl.put.poznan.sorter.enums.SortingMethodEnum;

import java.util.ArrayList;

@Service
public class InsertionSort implements Sorting{
    @Override
    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> arr, boolean asc) {
        int size = arr.size();
        System.out.print("Insertion! ");
        for (int i = 1; i < size; i++){
            int j = i - 1;
            T key = arr.get(i);
            while ((j >= 0) && ((!asc && key.compareTo(arr.get(j)) > 0) || (asc && key.compareTo(arr.get(j)) < 0))){
                arr.set(j+1, arr.get(j));
                j -= 1;
            }
            arr.set(j+1, key);
        }
        return arr;
    }

    @Override
    public SortingMethodEnum getSortingMethod() {
        return SortingMethodEnum.INSERTION;
    }
}
