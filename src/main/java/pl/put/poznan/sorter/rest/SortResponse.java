package pl.put.poznan.sorter.rest;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortResponse<T> {
    public ArrayList<T> result;
    public long executionTime;

    public void setResult(ArrayList<T> result){
        this.result = result;
    }
    public void setExecutionTime(long executionTime){
        this.executionTime = executionTime;
    }

    public ArrayList<T> getResult(){
        return this.result;
    }
    public long getExecutionTime(){
        return this.executionTime;
    }
    public SortResponse(){

    }
    public <T2> SortResponse(SortResponse<T2> response, Function<T2, T> converter){
        executionTime = response.executionTime;
        result = new ArrayList<T>(response.result.stream().map(converter).collect(Collectors.toList()));
    }
    @Override
    public String toString() {
        return "Time: " + executionTime + ", Array: [" +
                String.join(", ",result.stream().map(e -> e.toString()).collect(Collectors.toList())) +
                "]";
    }
}
