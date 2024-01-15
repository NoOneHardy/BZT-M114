package ch.bztf;

public class Converter {
    private static LZ78 lz;
    public static LZ78 convertToLZ78(String data) {
        lz = new LZ78();
        String lastWord = "";
        String currentWord;

        // TODO: Prozess beginnt am Anfang des data Strings/
        for (int i = 0; i < data.length(); i++) {
            // Aktuelles Wort auslesen
            currentWord = String.valueOf(data.charAt(i)).toLowerCase();
            // Falls das aktuelle Wort noch nicht bekannt ist
            if (!lz.getDictionary().containsKey(currentWord)) {
                // Das aktuelle Wort ins Wörterbuch hinzufügen
                addToDictionary(currentWord);
                // Das letzte Wort mit dem aktuellen Wort im Wörterbuch speichern
                if (!lastWord.isEmpty()) {
                    addToDictionary(lastWord + currentWord);
                }

                // Das letzte Wort als das aktuelle setzen
                lastWord = currentWord;
                addToCode(currentWord);
                continue;
            }
            // TODO
            lastWord += currentWord;
            boolean isNewWordFound = false;
            while (!isNewWordFound) {
                if (!lz.getDictionary().containsKey(lastWord)) {
                    isNewWordFound = true;
                    addToDictionary(lastWord);
                    addToCode(lastWord);
                }
            }

        }
        return lz;

    }

    public static void addToDictionary(String currentWord) {
        lz.getDictionary().put(currentWord, lz.getDictionary().size());
    }

    public static void addToCode(String currentWord) {
        lz.getCode().add(lz.getDictionary().get(currentWord));
    }
}
