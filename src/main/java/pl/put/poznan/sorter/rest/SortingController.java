package pl.put.poznan.sorter.rest;
import com.fasterxml.jackson.databind.JsonNode;
import jdk.jshell.spi.ExecutionControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sorter.enums.SortingMethodEnum;
import pl.put.poznan.sorter.logic.SortingStrategy;

/**
 * Controller class that handles requests to sort an array
 * */
@RestController
public class SortingController {
    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(SortingController.class);

    /**
     * Sorting strategy
     * @param request Request with array to sort
     * @return Sorted array
     * @param <T> Type of array
     * @throws ExecutionControl.NotImplementedException If sorting method is not implemented
     */
    public <T extends Comparable<T>> SortResponse<T> sort(SortRequest<T> request) throws ExecutionControl.NotImplementedException {
        logger.debug("Sort request: " + request);

        SortResponse<T> result = new SortResponse<T>();
        for (String algorithm : request.algorithms){
            SortingMethodEnum strategy = SortingMethodEnum.valueOf(algorithm);
            SortingStrategy sorting = new SortingStrategy(strategy);
            result.result = sorting.sort(request.array, request.ascending, request.maxIterations);
            result.executionTimes.putIfAbsent(algorithm, sorting.getExecutionTimeMilis());
        }

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
    public SortResponse<Float> sortFloats(@RequestBody SortRequest<Float> request) {
        try {
            return sort(request);
        } catch (ExecutionControl.NotImplementedException e) {
            //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            //TODO: handle bad request response code
            return null;
        }
    }

    @PostMapping(value = "/sortObjects", consumes = "application/json", produces = "application/json")
    public SortResponse<JsonNode> sortObjects(@RequestBody SortRequest<JsonNode> request){
        try {
            return new SortResponse<JsonNode>(sort(new SortRequest<JSON>(request, o -> new JSON(o, request.comperedKey))), o -> o.node);
        } catch (ExecutionControl.NotImplementedException e) {
            //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            //TODO: handle bad request response code
            return null;
        }
    }
}


