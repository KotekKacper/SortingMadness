package pl.put.poznan.sorter.logic;

import org.springframework.stereotype.Service;
import pl.put.poznan.sorter.enums.SortingMethodEnum;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BubbleSort implements Sorting{

    @Override
    public void sort(List<?> list) {
        System.out.println("Bubble! " + list.stream().sorted().collect(Collectors.toList()));
    }

    @Override
    public SortingMethodEnum getSortingMethod() {
        return SortingMethodEnum.BUBBLE;
    }
}
