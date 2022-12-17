package pl.put.poznan.sorter.rest;

import java.util.ArrayList;

public class SortRequest<T> {
    ArrayList<T> array;
    String alghoritm;
    boolean ascending;
}
