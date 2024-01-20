package ch.bztf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LZ78 {
    private final HashMap<String, Integer> dictionary = new HashMap<>();
    private final ArrayList<Integer> code = new ArrayList<>();

    private String wordFromData = "";

    public LZ78() {
    }

    public HashMap<String, Integer> getDictionary() {
        return dictionary;
    }

    public ArrayList<Integer> getCode() {
        return code;
    }

    public String formatDictionary() {
        List<Integer> numbers = dictionary.values().stream().sorted().toList();
        StringBuilder sb = new StringBuilder("{\n");
        for (int number : numbers) {
            for (String value : dictionary.keySet()) {
                if (dictionary.get(value) == number) {
                    sb.append("\t").append(number).append(": ").append(value);
                    if (number < numbers.size() ) sb.append(",");
                    sb.append("\n");
                    break;
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public HashMap<Integer, String> switchDictionary() {
        HashMap<Integer, String> newDictionary = new HashMap<>();

        List<Integer> numbers = dictionary.values().stream().sorted().toList();
        for (int number : numbers) {
            for (String value : dictionary.keySet()) {
                if (dictionary.get(value) == number) {
                    newDictionary.put(number, value);
                    break;
                }
            }
        }
        return newDictionary;
    }

    public void generateDictionary(String word) {
        wordFromData = word;
        for (char ch : word.toCharArray()) {
            if (!dictionary.containsKey(String.valueOf(ch))) {
                addToDictionary(String.valueOf(ch));
            }
        }
    }

    public void addToDictionary(String currentWord) {
        dictionary.put(currentWord, dictionary.size());
    }

    public void addToCode(String currentWord) {
        code.add(dictionary.get(currentWord));
    }

    public int getOriginalLength(){
        return wordFromData.length();
    }

    public int getCodeLength(){
        return code.size();
    }

    public int getDictionaryLength(){
        return dictionary.size();
    }

    public double getSavedStorage(){

        return  Math.round(100*(1- (((double) code.size() + (double) dictionary.size()) / (double) wordFromData.length())));
    }
}
