package pl.put.poznan.sorter.logic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortTest {
    static Sorting sorting;

    @BeforeAll
    static void setUp(){
        sorting = new BubbleSort();
    }

    @Test
    void testEmptyArray(){
        ArrayList arr = new ArrayList();
        boolean asc = true;
        int maxIterations = 0;

        ArrayList out_arr = sorting.sort(arr, asc, maxIterations);
        assertEquals(new ArrayList(), out_arr, "Empty array - ascending");

        out_arr = sorting.sort(arr, !asc, maxIterations);
        assertEquals(new ArrayList(), out_arr, "Empty array - descending");
    }

    @Test
    void testOneStringArray(){
        ArrayList arr = new ArrayList();
        arr.add("Hello");
        boolean asc = true;
        int maxIterations = 0;

        ArrayList out_arr = sorting.sort(arr, asc, maxIterations);
        assertEquals(arr, out_arr, "One string array - ascending");

        out_arr = sorting.sort(arr, !asc, maxIterations);
        assertEquals(arr, out_arr, "One string array - descending");
    }

    @Test
    void testOneIntArray(){
        ArrayList arr = new ArrayList();
        arr.add(5);
        boolean asc = true;
        int maxIterations = 0;

        ArrayList out_arr = sorting.sort(arr, asc, maxIterations);
        assertEquals(arr, out_arr, "One int array - ascending");

        out_arr = sorting.sort(arr, !asc, maxIterations);
        assertEquals(arr, out_arr, "One int array - descending");
    }


}
