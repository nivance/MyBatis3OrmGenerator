/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.github.test;

import java.security.SecureRandom;

/**
 * @author nivance
 *
 */
public class TokenGenerator {
    protected static final int DEFAULT_NEXT_BYTES_SIZE = 16;

    private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
            'f' };
    private static SecureRandom secureRandom = new SecureRandom();

    public static String nextToken() {
        return nextToken(DEFAULT_NEXT_BYTES_SIZE);
    }

    private static String nextToken(int numBytes) {
        byte[] bytes = new byte[numBytes];
        secureRandom.nextBytes(bytes);
        int l = bytes.length;
        char[] out = new char[l << 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = DIGITS[(0xF0 & bytes[i]) >>> 4];
            out[j++] = DIGITS[0x0F & bytes[i]];
        }
        return new String(out);
    }

}
