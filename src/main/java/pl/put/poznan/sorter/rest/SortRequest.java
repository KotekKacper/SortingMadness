package pl.put.poznan.sorter.rest;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Value;
import pl.put.poznan.sorter.enums.SortingMethodEnum;
import pl.put.poznan.sorter.logic.SortingStrategy;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Class that represents a request to sort an array
 * @param <T>
 *     Type of elements in array
 */

public class SortRequest<T> {
    /**
     * Array to sort
     */
    ArrayList<T> array;
    /**
     * Sorting algorithm
     */
    ArrayList<String> algorithms;
    /**
     * Sorting direction
     */
    boolean ascending;
    @Value("${comperedKey:}")
            /**
             * Key to compare objects by
             */
    String comperedKey;
    /**
     * Maximum number of iterations
     */
    int maxIterations;
    public void setArray(ArrayList<T> array){
        this.array = array;
    }
    public void setAlgorithms(ArrayList<String> algorithms){
        this.algorithms = algorithms;
    }
    public void setAscending(boolean ascending){
        this.ascending = ascending;
    }
    public void setComperedKey(String comperedKey){
        this.comperedKey = comperedKey;
    }

    public void setMaxIterations(int maxIterations) {this.maxIterations = maxIterations;}

    public ArrayList<T> getArray(){ return this.array; }
    public ArrayList<String> getAlgorithm(){
        return this.algorithms;
    }
    public boolean getAscending(){
        return this.ascending;
    }
    public String getComperedKey(){
        return this.comperedKey;
    }

    /**
     * Empty constructor that allows to create an empty object
     */
    public SortRequest(){

    }

    /**
     * Constructor that allows to create an object with parameters and convert data to proper types
     * @param request Request to sort an array
     * @param converter Function that converts request to array
     * @param <T2> Type of elements in array
     */
    public <T2> SortRequest(SortRequest<T2> request, Function<T2, T> converter){
        algorithms = request.algorithms;
        ascending = request.ascending;
        comperedKey = request.comperedKey;
        array = new ArrayList<T>(request.array.stream().map(converter).collect(Collectors.toList()));
    }

    /**
     * Returns sorting strategy
     * @return Sorting strategy
     */
    public int getMaxIterations(){ return this.maxIterations; }


    @Override
    /**
     * Returns string representation of this object
     * @return
     *    String representation of this object
     *    Format: "Algorithms: {algorithms}, ascending: {ascending}, comperedKey: {comperedKey}, array: {array}"
     */
    public String toString() {
        return "Algorithms: " + String.join(", ", algorithms) + (ascending ? " ASC" : " DESC") + ", Array: [" +
                String.join(", ",array.stream().map(e -> e.toString()).collect(Collectors.toList())) +
                "]";
    }
}
