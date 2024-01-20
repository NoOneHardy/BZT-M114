package ch.bztf;

import java.util.ArrayList;
import java.util.HashMap;

public class Converter {

    public static LZ78 convertToLZ78(String data) {
        LZ78 lz78 = new LZ78();
        String lastWord = "";
        String currentWord = "";
        String wordTogether;
        int dictionaryCounter = 1;
        int numberStorage = 0;

        HashMap<String, Integer> dictionary = lz78.getDictionary();
        ArrayList<Integer> result = lz78.getResult();

        for (int i = 0; i < data.length(); i++) {
            if (!dictionary.containsKey(String.valueOf(data.charAt(i)))){
                dictionary.put(String.valueOf(data.charAt(i)),dictionaryCounter);
                dictionaryCounter++;
            }
        }

        // TODO: Prozess beginnt am Anfang des data Strings/
        for (int i = 0; i < data.length(); i++) {
            currentWord = String.valueOf(data.toLowerCase().charAt(i));
            wordTogether = lastWord + currentWord;
            if (dictionary.containsKey(wordTogether)) {
                numberStorage = dictionary.get(wordTogether);
                lastWord = wordTogether;
            }

            else {
                if (numberStorage != 0){
                    dictionary.put(wordTogether, dictionaryCounter);
                    dictionaryCounter++;
                    result.add(numberStorage);
                    lastWord = currentWord;
                }
                else {
                    numberStorage++;
                }

            }
        }

        return lz78;
    }

    
}
