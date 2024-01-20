package ch.bztf;

import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {
        LZ78 lz78 = Converter.convertToLZ78("HAUSAUSE");


        System.out.println(lz78.getDictionary());
        System.out.println(lz78.getResult());
    }
}
