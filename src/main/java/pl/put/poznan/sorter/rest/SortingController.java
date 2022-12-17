package pl.put.poznan.sorter.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sorter.enums.SortingMethodEnum;
import pl.put.poznan.sorter.factory.SortingFactory;
import pl.put.poznan.sorter.logic.MyTimer;
import pl.put.poznan.sorter.logic.RandomIntArrayList;

import java.util.ArrayList;

@Controller
//@RequestMapping("/")
public class SortingController {
    private static final Logger logger = LoggerFactory.getLogger(SortingController.class);
    private final MyTimer timer = new MyTimer();
    ArrayList<Integer> intArr;
    @Autowired
    SortingFactory factory;

    // (@RequestParam SortingTypeEnum sortingTypeEnum)
    @PostMapping(value = "/sort")
    public void sortWithMethod(@RequestParam String algorithm){
        String[] algorithms = algorithm.split(",");
        for (String alg : algorithms){
            intArr = (new RandomIntArrayList(10000)).getRandomList();
            timer.go();
            intArr = factory.findSortingType(SortingMethodEnum.valueOf(alg)).sort(intArr, true);
            timer.stop();
            System.out.println(timer.getTimeMilli() + "ms");
        }
    }

    @GetMapping("/")
    public String chooseMethod(){
        return "index";
    }

    /* @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String text,
                              @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation, you should run your logic here, below is just a silly example
        Sorting transformer = new Sorting(transforms);
        return transformer.transform(text);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@PathVariable String text,
                      @RequestBody String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation, you should run your logic here, below is just a silly example
        Sorting transformer = new Sorting(transforms);
        return transformer.transform(text);
    }*/

}


