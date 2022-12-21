package pl.put.poznan.sorter.logic;

import jdk.jshell.spi.ExecutionControl;
import pl.put.poznan.sorter.enums.SortingMethodEnum;

import java.util.ArrayList;

/**
 * This is class that menages sorting strategies
 */
public class SortingStrategy {

    /**
     *  Time of sorting
     */
    MyTimer executionTime;
    /**
     * Method of sorting
     */
    Sorting sorting;

    /**
     * Constructor
     * @param strategy Sorting algorithm
     * @throws ExecutionControl.NotImplementedException if strategy is not implemented
     */
    public SortingStrategy(SortingMethodEnum strategy) throws ExecutionControl.NotImplementedException {
        setStrategy(strategy);
    }
    /**
     * Sets sorting algorithm to use in sort method of this class instance
     * @param strategy Sorting algorithm
     * @throws ExecutionControl.NotImplementedException if strategy is not implemented
     */
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
    /**
     * Sorts array using selected sorting algorithm
     * @param arr
     *     Array to sort
     * @param asc
     *     Sorting order
     * @param maxIterations
     *     Maximum number of iterations
     * @param <T>
     *     Type of elements in array
     * @return
     *     Sorted array
     */
    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> arr, boolean asc, int maxIterations)
    {
        executionTime = new MyTimer();
        executionTime.go();
        var result = sorting.sort(arr, asc, maxIterations);
        executionTime.stop();
        return result;
    }
    /**
     * Returns time of sorting in milliseconds since last call of sort method
     * @return
     *     Time of last sorting
     */
    public long getExecutionTimeMilis()
    {
        return executionTime.getTimeMilli();
    }
}
