package pl.put.poznan.sorter.logic;

import org.springframework.stereotype.Service;
import pl.put.poznan.sorter.enums.SortingMethodEnum;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class ShellSort implements Sorting{
    @Override
    public <T extends Comparable<T>> void sort(ArrayList<T> arr, boolean asc) {
        System.out.println("Shell! " + arr.stream().sorted().collect(Collectors.toList()));
    }

    @Override
    public SortingMethodEnum getSortingMethod() {
        return SortingMethodEnum.SHELL;
    }
}
