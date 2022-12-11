package pl.put.poznan.sorter.logic;

import org.springframework.stereotype.Service;
import pl.put.poznan.sorter.enums.SortingMethodEnum;

import java.util.List;

@Service
public class QuickSort implements Sorting{
    @Override
    public void sort(List<?> list) {
        System.out.println("Quick!");
    }

    @Override
    public SortingMethodEnum getSortingMethod() {
        return SortingMethodEnum.QUICK;
    }
}
