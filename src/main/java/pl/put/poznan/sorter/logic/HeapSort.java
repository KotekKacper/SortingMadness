package pl.put.poznan.sorter.logic;

import org.springframework.stereotype.Service;
import pl.put.poznan.sorter.enums.SortingMethodEnum;

import java.util.List;

@Service
public class HeapSort implements Sorting{
    @Override
    public void sort(List<?> list) {
        System.out.println("Heap!");
    }

    @Override
    public SortingMethodEnum getSortingMethod() {
        return SortingMethodEnum.HEAP;
    }
}
