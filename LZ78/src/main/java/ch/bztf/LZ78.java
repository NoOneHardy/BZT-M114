package ch.bztf;

import java.util.ArrayList;
import java.util.HashMap;

public class LZ78 {
    private final HashMap<String, Integer> dictionary = new HashMap<>();
    private final ArrayList<Integer> code = new ArrayList<>();

    public LZ78() {
    }

    public HashMap<String, Integer> getDictionary() {
        return dictionary;
    }

    public ArrayList<Integer> getCode() {
        return code;
    }
}
