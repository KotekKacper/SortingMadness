package pl.put.poznan.sorter.rest;

import java.util.ArrayList;

public class SortRequest<T> {
    ArrayList<T> array;
    String algorithm;
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

}
