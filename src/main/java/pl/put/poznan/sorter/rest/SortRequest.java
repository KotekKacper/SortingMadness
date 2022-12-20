package pl.put.poznan.sorter.rest;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SortRequest<T> {
    public ArrayList<T> array;
    public String algorithm;
    boolean ascending;
    public void setArray(ArrayList<T> array){
        this.array = array;
    }
    public void setAlgorithm(String algorithm){
        this.algorithm = algorithm;
    }
    public void setAscending(boolean ascending){
        this.ascending = ascending;
    }

    public ArrayList<T> getArray(){
        return this.array;
    }
    public String getAlgorithm(){
        return this.algorithm;
    }
    public boolean getAscending(){
        return this.ascending;
    }


    @Override
    public String toString() {
        return "Alghoritm: " + algorithm + (ascending ? " ASC" : " DESC") + ", Array: [" +
                String.join(", ",array.stream().map(e -> e.toString()).collect(Collectors.toList())) +
                "]";
    }
}
