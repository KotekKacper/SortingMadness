package pl.put.poznan.sorter.rest;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
/**
 * Class that represents a response from sorting service
 */
public class SortResponse<T> {
    /**
     * Sorted array
     */
    public ArrayList<T> result;
    /**
     * Sorting execution time
     */
    public long executionTime;
    /**
     * Sets result
     * @param result Sorted array
     */
    public void setResult(ArrayList<T> result){
        this.result = result;
    }
    /**
     * Sets execution time
     * @param executionTime Sorting execution time
     */
    public void setExecutionTime(long executionTime){
        this.executionTime = executionTime;
    }

    /**
     * Gets result
     * @return Sorted array
     */
    public ArrayList<T> getResult(){
        return this.result;
    }
    /**
     * Gets execution time
     * @return Execution time
     */
    public long getExecutionTime(){
        return this.executionTime;
    }

    /**
     * Empty constructor
     */
    public SortResponse(){

    }

    /**
     * Constructor with parameters
     * @param response Response from sorting service
     * @param converter Converter from sorting service response to SortResponse
     * @param <T2> Type of elements in sorting service response
     */
    public <T2> SortResponse(SortResponse<T2> response, Function<T2, T> converter){
        executionTime = response.executionTime;
        result = new ArrayList<T>(response.result.stream().map(converter).collect(Collectors.toList()));
    }

    /**
     * Converts response from sorting response to String
     * @return String representation of sorting response
     */
    @Override
    public String toString() {
        return "Time: " + executionTime + ", Array: [" +
                String.join(", ",result.stream().map(e -> e.toString()).collect(Collectors.toList())) +
                "]";
    }
}
