package pl.put.poznan.sorter.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
    public Map<String, Long> executionTimes = new HashMap<String, Long>();
    /**
     * Sets result
     * @param result Sorted array
     */
    public void setResult(ArrayList<T> result){
        this.result = result;
    }
    /**
     * Sets execution time for sorting algorithm
     * @param algorithm Alghorithm to set execution time of
     * @param executionTimeMilis Sorting execution time in miliseconds
     */
    public void setExecutionTime(String algorithm, long executionTimeMilis){
        this.executionTimes.putIfAbsent(algorithm, executionTimeMilis);
    }

    /**
     * Gets result
     * @return Sorted array
     */
    public ArrayList<T> getResult(){
        return this.result;
    }
    /**
     * Gets execution times
     * @return Execution times
     */
    public Map<String, Long> getExecutionTimes(){
        return this.executionTimes;
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
        executionTimes = response.executionTimes;
        result = new ArrayList<T>(response.result.stream().map(converter).collect(Collectors.toList()));
    }

    /**
     * Sets result
     * @param map Map to convert to string
     * @return String representation of the map
     */
    private String mapToString(Map<?, ?> map) {
        String mapAsString = map.keySet().stream()
                .map(key -> key + "=" + map.get(key))
                .collect(Collectors.joining(", ", "{", "}"));
        return mapAsString;
    }

    /**
     * Converts response from sorting response to String
     * @return String representation of sorting response
     */
    @Override
    public String toString() {
        return "Time: " + mapToString(executionTimes) + ", Array: [" +
                String.join(", ",result.stream().map(e -> e.toString()).collect(Collectors.toList())) +
                "]";
    }
}
