package pl.put.poznan.sorter.rest;

import java.util.ArrayList;

public class SortResponse<T> {
    ArrayList<T> result;
    long executionTime;

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
}
