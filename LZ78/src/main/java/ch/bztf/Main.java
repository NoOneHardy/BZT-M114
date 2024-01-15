package ch.bztf;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("LZ78 Generator");
        System.out.print("Bitte geben Sie ein Wort ein: ");
        String word = scan.nextLine();
        System.out.println("Dieser String wird in den folgenden Zahlen gesendet: " + Converter.convertToLZ78(word));
        
        
    }
}
