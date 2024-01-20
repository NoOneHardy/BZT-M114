package ch.bztf;

import java.util.ArrayList;
import java.util.HashMap;

public class LZ78 {
    private HashMap<String, Integer> dictionary = new HashMap<>();

    private ArrayList<Integer> result = new ArrayList<>();

    public ArrayList<Integer> getResult() {
        return result;
    }

    public HashMap<String,Integer> getDictionary() {
        return dictionary;
    }

}
