package pl.put.poznan.sorter.rest;
import jdk.jshell.spi.ExecutionControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sorter.enums.SortingMethodEnum;
import pl.put.poznan.sorter.logic.SortingStrategy;

@RestController
public class SortingController {
    private static final Logger logger = LoggerFactory.getLogger(SortingController.class);
    public <T extends Comparable<T>> SortResponse<T> sort(SortRequest<T> request) throws ExecutionControl.NotImplementedException {
        logger.debug("Sort request: " + request);
        // System.out.println(request.algorithm + request.array.toString());
        SortingMethodEnum strategy = SortingMethodEnum.valueOf(request.algorithm);
        SortingStrategy sorting = new SortingStrategy(strategy);

        SortResponse<T> result = new SortResponse<T>();
        result.result = sorting.sort(request.array, request.ascending);
        result.executionTime = sorting.getExecutionTime();
        logger.debug("Sort result: " + result);
        return result;
    }

    @PostMapping(value = "/sortStrings", consumes = "application/json", produces = "application/json")
    public SortResponse<String> sortStrings(@RequestBody SortRequest<String> request){
        logger.info("Called endpoint /sortStrings");
        try {
            return sort(request);
        } catch (ExecutionControl.NotImplementedException e) {
            //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            //TODO: handle bad request response code
            return null;
        }
    }

    @PostMapping(value = "/sortInts", consumes = "application/json", produces = "application/json")
    public SortResponse<Integer> sortInts(@RequestBody SortRequest<Integer> request){
        try {
            return sort(request);
        } catch (ExecutionControl.NotImplementedException e) {
            //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            //TODO: handle bad request response code
            return null;
        }
    }

    @PostMapping(value = "/sortFloats", consumes = "application/json", produces = "application/json")
    public SortResponse<Float> sortFloats(@RequestBody SortRequest<Float> request){
        try {
            return sort(request);
        } catch (ExecutionControl.NotImplementedException e) {
            //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            //TODO: handle bad request response code
            return null;
        }
    }
}


