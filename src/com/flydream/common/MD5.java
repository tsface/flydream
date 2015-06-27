package com.flydream.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    
    // 鍏ㄥ眬鏁扮粍
    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public MD5() {
    }

    // 杩斿洖褰㈠紡涓烘暟瀛楄窡瀛楃涓?
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        // System.out.println("iRet="+iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    // 杩斿洖褰㈠紡鍙负鏁板瓧
    private static String byteToNum(byte bByte) {
        int iRet = bByte;
        System.out.println("iRet1=" + iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }

    // 杞崲瀛楄妭鏁扮粍涓?6杩涘埗瀛椾覆
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    public static String GetMD5Code(String strObj) {
        String resultString = null;
        try {
            resultString = new String(strObj);
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 璇ュ嚱鏁拌繑鍥炲?涓哄瓨鏀惧搱甯屽?缁撴灉鐨刡yte鏁扮粍
            resultString = byteToString(md.digest(strObj.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }

    public static void main(String[] args) {
        MD5 getMD5 = new MD5();
        System.out.println(getMD5.GetMD5Code("123"));
    }
}