package pl.put.poznan.sorter.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.put.poznan.sorter.enums.SortingMethodEnum;
import pl.put.poznan.sorter.logic.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// As soon as application will start the @Component will be found by the app context
// All methods will be called at runtime
@Component
public class SortingFactory {
    Map<SortingMethodEnum, Sorting> map;
    @Autowired
    public SortingFactory(Set<Sorting> sortingTypesSet){ // TODO fix sortingTypesSet = null, ???
        Set<Sorting> set = Set.of(new BubbleSort(), new QuickSort(), new ShellSort(), new InsertionSort(), new HeapSort(), new SelectionSort());
        // createStrategy(sortingTypesSet);
        createStrategy(set);
    }

    private void createStrategy(Set<Sorting> sortingTypesSet) {
        map = new HashMap<SortingMethodEnum, Sorting>();
        sortingTypesSet.stream().forEach(sortingTypes ->
                map.put(sortingTypes.getSortingMethod(), sortingTypes));
    }

    // child of Sorting, dynamic binding
    public Sorting findSortingType(SortingMethodEnum sortingEnum){
        return map.get(sortingEnum);
    }
}
