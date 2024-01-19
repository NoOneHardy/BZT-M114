package ch.bztf;

import java.util.HashMap;
import java.util.List;

public class Converter {


    public static LZ78 convertToLZ78(String data) {
        LZ78 lz = new LZ78();
        lz.generateDictionary(data);

        StringBuilder lastWord = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            String currentWord = String.valueOf(data.charAt(i)).toLowerCase();

            if (lastWord.isEmpty()) {
                lastWord = new StringBuilder(currentWord);
                continue;
            }

            if (!lz.getDictionary().containsKey(lastWord + currentWord)) {
                lz.addToDictionary(lastWord + currentWord);
                lz.addToCode(lastWord.toString());
                lastWord = new StringBuilder(currentWord);
                if (i == data.length() - 1) {
                    lz.addToCode(lastWord.toString());
                }
                continue;
            }

            lastWord.append(currentWord);

            if (i == data.length() - 1) {
                lz.addToCode(lastWord.toString());
            }
        }
        return lz;
    }

    public static String convertFromLZ78(LZ78 data) {
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, String> dictionary = data.switchDictionary();
        for (int bit : data.getCode()) {
            sb.append(dictionary.get(bit));
        }
        return sb.toString();
    }
}
