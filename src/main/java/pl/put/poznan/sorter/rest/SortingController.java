package pl.put.poznan.sorter.rest;
import com.fasterxml.jackson.databind.JsonNode;
import jdk.jshell.spi.ExecutionControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     * @throws java.lang.IllegalArgumentException If sorting method is not declared in enum
     */
    public <T extends Comparable<T>> SortResponse<T> sort(SortRequest<T> request)
            throws ExecutionControl.NotImplementedException, java.lang.IllegalArgumentException {
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
    public ResponseEntity<SortResponse<String>> sortStrings(@RequestBody SortRequest<String> request){
        logger.info("Called endpoint /sortStrings");
        try {
            if (request.array.isEmpty()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            return ResponseEntity.ok(sort(request));
        } catch (ExecutionControl.NotImplementedException | java.lang.IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping(value = "/sortInts", consumes = "application/json", produces = "application/json")
    public ResponseEntity<SortResponse<Integer>> sortInts(@RequestBody SortRequest<Integer> request){
        try {
            if (request.array.isEmpty()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            return ResponseEntity.ok(sort(request));
        } catch (ExecutionControl.NotImplementedException | java.lang.IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping(value = "/sortFloats", consumes = "application/json", produces = "application/json")
    public ResponseEntity<SortResponse<Float>> sortFloats(@RequestBody SortRequest<Float> request) {
        try {
            if (request.array.isEmpty()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            return ResponseEntity.ok(sort(request));
        } catch (ExecutionControl.NotImplementedException | java.lang.IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping(value = "/sortObjects", consumes = "application/json", produces = "application/json")
    public ResponseEntity<SortResponse<JsonNode>> sortObjects(@RequestBody SortRequest<JsonNode> request){
        try {
            if (request.array.isEmpty()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            return ResponseEntity.ok(
                    new SortResponse<JsonNode>(
                            sort(new SortRequest<JSON>(request, o -> new JSON(o, request.comperedKey))),
                            o -> o.node
                    )
            );
        } catch (ExecutionControl.NotImplementedException | java.lang.IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}


