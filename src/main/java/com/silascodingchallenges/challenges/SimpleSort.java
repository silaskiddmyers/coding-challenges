package com.silascodingchallenges.challenges;

import java.util.ArrayList;
import java.util.List;

public class SimpleSort {
    public List<Integer> sort(List<Integer> toSort) {
        List<Integer> sorted = new ArrayList<Integer>();
        int min = 0;
        for(int i = 0; i < toSort.size(); i++) {
            min = min(toSort, min);
            sorted.add(min);
            
        }

        return sorted;
    }

    public Integer min(List<Integer> toMin, int lastMin) {
        int min = toMin.get(0);
        for(int x : toMin) {
            if (x < min && x > lastMin) {
                min = x;
            }
        }
        return min;
    }
}
