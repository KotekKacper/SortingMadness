package pl.put.poznan.sorter.logic;

import org.springframework.stereotype.Service;
import pl.put.poznan.sorter.enums.SortingMethodEnum;

import java.util.List;

@Service
public class BubbleSort implements Sorting{

    @Override
    public void sort(List<?> list) {
        System.out.println("Bubble!");
    }

    @Override
    public SortingMethodEnum getSortingMethod() {
        return SortingMethodEnum.BUBBLE;
    }
}
