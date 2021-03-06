package com.harsha.springdomainevents.domain.global.ids;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class IdEncoder {
    public static String encode(String builderStr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] shaHash = messageDigest.digest(builderStr.getBytes());
            return convertByteArrayToHexString(shaHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String convertByteArrayToHexString(byte[] arrayBytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayBytes.length; i++) {
            stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return stringBuffer.toString();
    }
}
