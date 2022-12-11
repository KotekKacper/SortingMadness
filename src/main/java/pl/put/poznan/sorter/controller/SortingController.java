package pl.put.poznan.sorter.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sorter.enums.SortingMethodEnum;
import pl.put.poznan.sorter.factory.SortingFactory;

import java.util.List;

@Controller
//@RequestMapping("/")
public class SortingController {
    private static final Logger logger = LoggerFactory.getLogger(SortingController.class);

    @Autowired
    SortingFactory factory;

    // (@RequestParam SortingTypeEnum sortingTypeEnum)
    @PostMapping(value = "/sort")
    public void sortWithMethod(@RequestParam String algorithm){
        System.out.println(SortingMethodEnum.valueOf(algorithm));
        // factory.findSortingType(SortingMethodEnum.valueOf(algorithm)).sort(List.of(1,4,3,4)); // TODO fix NullPointerException
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


