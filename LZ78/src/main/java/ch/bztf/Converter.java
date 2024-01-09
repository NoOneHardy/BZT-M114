package ch.bztf;

import java.util.ArrayList;

public class Converter {
    public static ArrayList<Short> convertToLZ78(String data) {
        ArrayList<String> dictionary = new ArrayList<>();
        String lastWord = "";
        String currentWord = "";
        ArrayList<Short> result = new ArrayList<>();

        // TODO: Prozess beginnt am Anfang des data Strings/
        for (int i = 0; i < data.length(); i++) {
            currentWord = String.valueOf(data.charAt(i));
            if (!dictionary.contains(currentWord)) {
                dictionary.add(currentWord);
                lastWord = currentWord;
                break;
            }
        }






        return result;
    }
}
