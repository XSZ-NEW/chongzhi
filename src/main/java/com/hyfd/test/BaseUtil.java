package com.hyfd.test;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;

public class BaseUtil {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "[0xe6][0x97][0xa0][0xe7][0x94][0xa8][0xe6][0x88][0xb7][0xe8][0xb5][0x84][0xe6][0x96][0x99]";
        str = str.replaceAll("\\[0x", "").replaceAll("\\]", "");
//    byte[] helloBytes = "这".getBytes();
//    System.out.println(helloBytes);
//    String helloHex = DatatypeConverter.printHexBinary(helloBytes);
//    String  ss = "0xE8BF99";
        System.out.printf("Hello hex: 0x%s\n", str);
//convert hex-encoded string back to original string
        byte[] decodedHex = DatatypeConverter.parseHexBinary(str);
        String decodedString = new String(decodedHex, "UTF-8");
        System.out.printf("Hello decoded : %s\n", decodedString);
    }
}
