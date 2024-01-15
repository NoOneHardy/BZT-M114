package ch.bztf;

import java.util.ArrayList;

public class Converter {
    public static ArrayList<Integer> convertToLZ78(String data) {
        ArrayList<String> dictionary = new ArrayList<>();
        String lastWord = "";
        String currentWord;
        ArrayList<Integer> result = new ArrayList<>();

        // TODO: Prozess beginnt am Anfang des data Strings/
        for (int i = 0; i < data.length(); i++) {
            currentWord = String.valueOf(data.charAt(i));
            if (!dictionary.contains(currentWord)) {
                dictionary.add(currentWord);
                lastWord = currentWord;
                result.add(dictionary.indexOf(currentWord));
                break;
            } else {

            }
        }

        return result;
    }

    
}
