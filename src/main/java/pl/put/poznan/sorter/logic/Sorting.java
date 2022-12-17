package pl.put.poznan.sorter.logic;

import pl.put.poznan.sorter.enums.SortingMethodEnum;

import java.util.ArrayList;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public interface Sorting {
    <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> arr, boolean asc);

    SortingMethodEnum getSortingMethod();

    /*private final String[] transforms;

    public Sorting(String[] transforms){
        this.transforms = transforms;
    }

    public String transform(String text){
        of course, normally it would do something based on the transforms
        return text.toUpperCase();
    }*/
}
