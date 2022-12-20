package pl.put.poznan.sorter.logic;

import jdk.jshell.spi.ExecutionControl;
import pl.put.poznan.sorter.enums.SortingMethodEnum;

import java.util.ArrayList;

public class SortingStrategy {

    MyTimer executionTime;
    Sorting sorting;

    public SortingStrategy(SortingMethodEnum strategy) throws ExecutionControl.NotImplementedException {
        setStrategy(strategy);
    }

    void setStrategy(SortingMethodEnum strategy) throws ExecutionControl.NotImplementedException {
        switch(strategy)
        {
            case HEAP:
                sorting = new HeapSort();
                break;
            case QUICK:
                sorting = new QuickSort();
                break;

            case SHELL:
                sorting = new ShellSort();
                break;

            case BUBBLE:
                sorting = new BubbleSort();
                break;

            case INSERTION:
                sorting = new InsertionSort();
                break;

            case SELECTION:
                sorting = new SelectionSort();
                break;

            default:
                throw new ExecutionControl.NotImplementedException("Following strategy is not implemented");
        }
    }

    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> arr, boolean asc)
    {
        executionTime = new MyTimer();
        executionTime.go();
        var result = sorting.sort(arr, asc);
        executionTime.stop();
        return result;
    }

    public long getExecutionTime()
    {
        return executionTime.getTimeMilli();
    }
}
