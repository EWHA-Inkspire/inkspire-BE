package com.example.inkspire.config;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

public class ShaUtil {

    private static final SecureRandom random = new SecureRandom();

    public static String getSalt() {
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        return Base64.getEncoder().encodeToString(salt);
    }

    public static String getEncryptPw(String plainText, String salt) {
        return Hashing.sha256()
                .hashString(plainText + salt, StandardCharsets.UTF_8)
                .toString();
    }

}
