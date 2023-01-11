package pl.put.poznan.sorter.logic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

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

    @Test
    void testOneFloatArray(){
        ArrayList arr = new ArrayList();
        arr.add(17.3);
        boolean asc = true;
        int maxIterations = 0;

        ArrayList out_arr = sorting.sort(arr, asc, maxIterations);
        assertEquals(arr, out_arr, "One float array - ascending");

        out_arr = sorting.sort(arr, !asc, maxIterations);
        assertEquals(arr, out_arr, "One float array - descending");
    }

//  TODO - make object for sorting using mock objects
//    void testOneObjectArray(){
//        ArrayList arr = new ArrayList();
//        arr.add();
//        boolean asc = true;
//        int maxIterations = 0;
//
//        ArrayList out_arr = sorting.sort(arr, asc, maxIterations);
//        assertEquals(arr, out_arr, "One object array - ascending");
//
//        out_arr = sorting.sort(arr, !asc, maxIterations);
//        assertEquals(arr, out_arr, "One object array - descending");
//    }
    @Test
    void testStringArray(){
        ArrayList arr = new ArrayList();
        arr.add("Hello");
        arr.add("there");
        arr.add("how");
        arr.add("you");
        arr.add("doin");
        ArrayList exp_arr = new ArrayList();
        exp_arr.add("Hello");
        exp_arr.add("doin");
        exp_arr.add("how");
        exp_arr.add("there");
        exp_arr.add("you");
        boolean asc = true;
        int maxIterations = 0;

        ArrayList out_arr = sorting.sort(arr, asc, maxIterations);
        assertEquals(exp_arr, out_arr, "String array - ascending");

        Collections.reverse(exp_arr);
        out_arr = sorting.sort(arr, !asc, maxIterations);
        assertEquals(exp_arr, out_arr, "String array - descending");
    }

    @Test
    void testIntArray(){
        ArrayList arr = new ArrayList();
        arr.add(5);
        arr.add(3);
        arr.add(22);
        arr.add(51);
        arr.add(123232135);
        arr.add(0);
        arr.add(2);
        ArrayList exp_arr = new ArrayList();
        exp_arr.add(0);
        exp_arr.add(2);
        exp_arr.add(3);
        exp_arr.add(5);
        exp_arr.add(22);
        exp_arr.add(51);
        exp_arr.add(123232135);
        boolean asc = true;
        int maxIterations = 0;

        ArrayList out_arr = sorting.sort(arr, asc, maxIterations);
        assertEquals(exp_arr, out_arr, "Int array - ascending");

        Collections.reverse(exp_arr);
        out_arr = sorting.sort(arr, !asc, maxIterations);
        assertEquals(exp_arr, out_arr, "Int array - descending");
    }

    @Test
    void testFloatArray(){
        ArrayList arr = new ArrayList();
        arr.add(5.3);
        arr.add(12.23);
        arr.add(10.11111111111);
        arr.add(23123123123.0);
        arr.add(123232135.123123123123);
        arr.add(0.0);
        ArrayList exp_arr = new ArrayList();
        exp_arr.add(0.0);
        exp_arr.add(5.3);
        exp_arr.add(10.11111111111);
        exp_arr.add(12.23);
        exp_arr.add(123232135.123123123123);
        exp_arr.add(23123123123.0);
        boolean asc = true;
        int maxIterations = 0;

        ArrayList out_arr = sorting.sort(arr, asc, maxIterations);
        assertEquals(exp_arr, out_arr, "Float array - ascending");

        Collections.reverse(exp_arr);
        out_arr = sorting.sort(arr, !asc, maxIterations);
        assertEquals(exp_arr, out_arr, "Float array - descending");
    }

//  TODO - make object for sorting using mock objects
//    void testObjectArray(){
//        ArrayList arr = new ArrayList();
//        arr.add();
//        boolean asc = true;
//        int maxIterations = 0;
//
//        ArrayList out_arr = sorting.sort(arr, asc, maxIterations);
//        assertEquals(arr, out_arr, "One object array - ascending");
//
//        out_arr = sorting.sort(arr, !asc, maxIterations);
//        assertEquals(arr, out_arr, "One object array - descending");
//    }
    @Test
    void testNegativeIntArray(){
        ArrayList arr = new ArrayList();
        arr.add(-5);
        arr.add(-3);
        arr.add(-22);
        arr.add(-51);
        arr.add(-123232135);
        arr.add(0);
        arr.add(-2);
        ArrayList exp_arr = new ArrayList();
        exp_arr.add(0);
        exp_arr.add(-2);
        exp_arr.add(-3);
        exp_arr.add(-5);
        exp_arr.add(-22);
        exp_arr.add(-51);
        exp_arr.add(-123232135);
        Collections.reverse(exp_arr);
        boolean asc = true;
        int maxIterations = 0;

        ArrayList out_arr = sorting.sort(arr, asc, maxIterations);
        assertEquals(exp_arr, out_arr, "Negative int array - ascending");

        Collections.reverse(exp_arr);
        out_arr = sorting.sort(arr, !asc, maxIterations);
        assertEquals(exp_arr, out_arr, "Negative int array - descending");
    }

    @Test
    void testNegativeFloatArray(){
        ArrayList arr = new ArrayList();
        arr.add(-5.3);
        arr.add(-12.23);
        arr.add(-10.11111111111);
        arr.add(-23123123123.0);
        arr.add(-123232135.123123123123);
        arr.add(0.0);
        ArrayList exp_arr = new ArrayList();
        exp_arr.add(0.0);
        exp_arr.add(-5.3);
        exp_arr.add(-10.11111111111);
        exp_arr.add(-12.23);
        exp_arr.add(-123232135.123123123123);
        exp_arr.add(-23123123123.0);
        Collections.reverse(exp_arr);
        boolean asc = true;
        int maxIterations = 0;

        ArrayList out_arr = sorting.sort(arr, asc, maxIterations);
        assertEquals(exp_arr, out_arr, "Negative float array - ascending");

        Collections.reverse(exp_arr);
        out_arr = sorting.sort(arr, !asc, maxIterations);
        assertEquals(exp_arr, out_arr, "Negative float array - descending");
    }

    @Test
    void testPositiveNegativeIntArray(){
        ArrayList arr = new ArrayList();
        arr.add(51);
        arr.add(4);
        arr.add(12);
        arr.add(-5);
        arr.add(-3);
        arr.add(-22);
        arr.add(2131231);
        arr.add(-51);
        arr.add(-123232135);
        arr.add(33);
        arr.add(0);
        arr.add(-2);
        ArrayList exp_arr = new ArrayList();
        exp_arr.add(2131231);
        exp_arr.add(51);
        exp_arr.add(33);
        exp_arr.add(12);
        exp_arr.add(4);
        exp_arr.add(0);
        exp_arr.add(-2);
        exp_arr.add(-3);
        exp_arr.add(-5);
        exp_arr.add(-22);
        exp_arr.add(-51);
        exp_arr.add(-123232135);
        Collections.reverse(exp_arr);
        boolean asc = true;
        int maxIterations = 0;

        ArrayList out_arr = sorting.sort(arr, asc, maxIterations);
        assertEquals(exp_arr, out_arr, "Positive and negative int array - ascending");

        Collections.reverse(exp_arr);
        out_arr = sorting.sort(arr, !asc, maxIterations);
        assertEquals(exp_arr, out_arr, "Positive and negative int array - descending");
    }

    @Test
    void testPositiveNegativeFloatArray(){
        ArrayList arr = new ArrayList();
        arr.add(-5.3);
        arr.add(1.10001);
        arr.add(0.1);
        arr.add(-12.23);
        arr.add(-10.11111111111);
        arr.add(2323.22312312);
        arr.add(-23123123123.0);
        arr.add(123123123123.543853645);
        arr.add(-123232135.123123123123);
        arr.add(0.0);
        arr.add(0.00000000001);
        ArrayList exp_arr = new ArrayList();
        exp_arr.add(123123123123.543853645);
        exp_arr.add(2323.22312312);
        exp_arr.add(1.10001);
        exp_arr.add(0.1);
        exp_arr.add(0.00000000001);
        exp_arr.add(0.0);
        exp_arr.add(-5.3);
        exp_arr.add(-10.11111111111);
        exp_arr.add(-12.23);
        exp_arr.add(-123232135.123123123123);
        exp_arr.add(-23123123123.0);
        Collections.reverse(exp_arr);
        boolean asc = true;
        int maxIterations = 0;

        ArrayList out_arr = sorting.sort(arr, asc, maxIterations);
        assertEquals(exp_arr, out_arr, "Positive and negative float array - ascending");

        Collections.reverse(exp_arr);
        out_arr = sorting.sort(arr, !asc, maxIterations);
        assertEquals(exp_arr, out_arr, "Positive and negative float array - descending");
    }

    @Test
    void testSpecialCharactersStringArray(){
        ArrayList arr = new ArrayList();
        arr.add("?*''()#");
        arr.add("gżegżółka");
        arr.add("dźwiękować");
        arr.add("śż");
        arr.add("ń");
        ArrayList exp_arr = new ArrayList();
        exp_arr.add("?*''()#");
        exp_arr.add("dźwiękować");
        exp_arr.add("gżegżółka");
        exp_arr.add("ń");
        exp_arr.add("śż");
        boolean asc = true;
        int maxIterations = 0;

        ArrayList out_arr = sorting.sort(arr, asc, maxIterations);
        assertEquals(exp_arr, out_arr, "String array with special characters - ascending");

        Collections.reverse(exp_arr);
        out_arr = sorting.sort(arr, !asc, maxIterations);
        assertEquals(exp_arr, out_arr, "String array with special characters - descending");
    }

}
