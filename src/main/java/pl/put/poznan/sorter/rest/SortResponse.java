package pl.put.poznan.sorter.rest;

import java.util.ArrayList;
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

    @Override
    public String toString() {
        return "Time: " + executionTime + ", Array: [" +
                String.join(", ",result.stream().map(e -> e.toString()).collect(Collectors.toList())) +
                "]";
    }
}
