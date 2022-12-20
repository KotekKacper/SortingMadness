package pl.put.poznan.sorter.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomIntArrayList {
    ArrayList<Integer> list = new ArrayList<>();
    public RandomIntArrayList(int size){
        for (int i = 0; i < size; i++){
            list.add(i);
        }
        Collections.shuffle(list, new Random());
    }

    public ArrayList<Integer> getRandomList(){
        return list;
    }
}
