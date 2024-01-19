package ch.bztf;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("LZ78 Generator");
        System.out.print("Bitte geben Sie ein Wort ein: ");
        String word = scan.nextLine();
        LZ78 lz = Converter.convertToLZ78(word.toLowerCase());
        System.out.println("Dictionary:\n" + lz.formatDictionary());
        System.out.println("Code: " + lz.getCode());
        System.out.println();
        System.out.print("Möchten Sie die verschlüsselte Nachricht entschlüsseln? (j/N) ");
        String answer = scan.nextLine();
        if (answer.equals("j")) {
            System.out.println(Converter.convertFromLZ78(lz));
        }
    }
}
