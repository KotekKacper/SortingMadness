package pl.put.poznan.sorter.rest;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Value;
import pl.put.poznan.sorter.enums.SortingMethodEnum;
import pl.put.poznan.sorter.logic.SortingStrategy;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortRequest<T> {
    ArrayList<T> array;
    String algorithm;
    boolean ascending;
    @Value("${comperedKey:}")
    String comperedKey;
    int maxIterations;
    public void setArray(ArrayList<T> array){
        this.array = array;
    }
    public void setAlgorithm(String algorithm){
        this.algorithm = algorithm;
    }
    public void setAscending(boolean ascending){
        this.ascending = ascending;
    }
    public void setComperedKey(String comperedKey){
        this.comperedKey = comperedKey;
    }

    public void setMaxIterations(int maxIterations) {this.maxIterations = maxIterations;}

    public ArrayList<T> getArray(){ return this.array; }
    public String getAlgorithm(){
        return this.algorithm;
    }
    public boolean getAscending(){
        return this.ascending;
    }
    public String getComperedKey(){
        return this.comperedKey;
    }
    public SortRequest(){

    }
    public <T2> SortRequest(SortRequest<T2> request, Function<T2, T> converter){
        algorithm = request.algorithm;
        ascending = request.ascending;
        comperedKey = request.comperedKey;
        array = new ArrayList<T>(request.array.stream().map(converter).collect(Collectors.toList()));
    }
    public int getMaxIterations(){ return this.maxIterations; }

    @Override
    public String toString() {
        return "Algorithm: " + algorithm + (ascending ? " ASC" : " DESC") + ", Array: [" +
                String.join(", ",array.stream().map(e -> e.toString()).collect(Collectors.toList())) +
                "]";
    }
}
