package pl.put.poznan.sorter.rest;
import jdk.jshell.spi.ExecutionControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sorter.enums.SortingMethodEnum;
import pl.put.poznan.sorter.factory.SortingFactory;
import pl.put.poznan.sorter.logic.MyTimer;
import pl.put.poznan.sorter.logic.RandomIntArrayList;
import pl.put.poznan.sorter.logic.SortingStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SortingController {
    private static final Logger logger = LoggerFactory.getLogger(SortingController.class);
    public <T extends Comparable<T>> SortResponse<T> sort(@RequestBody SortRequest<T> request) throws ExecutionControl.NotImplementedException {
        SortingMethodEnum strategy = SortingMethodEnum.valueOf(request.alghoritm);
        SortingStrategy sorting = new SortingStrategy(strategy);

        SortResponse<T> result = new SortResponse<T>();
        result.result = sorting.sort(request.array, request.ascending);
        result.executionTime = sorting.getExecutionTime();

        return result;
    }

    @PostMapping(value = "/sortStrings", consumes = "application/json", produces = "application/json")
    public SortResponse<String> sortStrings(@RequestBody SortRequest<String> request){
        try {
            return sort(request);
        } catch (ExecutionControl.NotImplementedException e) {
            //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            //TODO: handle bad request response code
            return null;
        }
    }
}


