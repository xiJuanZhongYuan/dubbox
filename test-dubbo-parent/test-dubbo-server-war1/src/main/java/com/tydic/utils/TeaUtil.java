package com.tydic.utils;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
 
/*
 * XXTEA 解密算法
 */
public class TeaUtil {
    public static String Encrypt(String data) {
        return ToHexString(TEAEncrypt(
                ToLongArray(PadRight(data, MIN_LENGTH).getBytes(
                        Charset.forName("UTF8"))),
                ToLongArray(PadRight(KEY, MIN_LENGTH).getBytes(
                        Charset.forName("UTF8")))));
    }
 
    public static String Decrypt(String data) {
        if (data == null || data.length() < MIN_LENGTH) {
            return data;
        }
        byte[] code = ToByteArray(TEADecrypt(
                ToLongArray(data),
                ToLongArray(PadRight(KEY, MIN_LENGTH).getBytes(
                        Charset.forName("UTF8")))));
        return new String(code, Charset.forName("UTF8"));
    }
 
    private static long[] TEAEncrypt(long[] data, long[] key) {
        int n = data.length;
        if (n < 1) {
            return data;
        }
 
        long z = data[data.length - 1], y = data[0], sum = 0, e, p, q;
        q = 6 + 52 / n;
        while (q-- > 0) {
            sum += DELTA;
            e = (sum >> 2) & 3;
            for (p = 0; p < n - 1; p++) {
                y = data[(int) (p + 1)];
                z = data[(int) p] += (z >> 5 ^ y << 2) + (y >> 3 ^ z << 4)
                        ^ (sum ^ y) + (key[(int) (p & 3 ^ e)] ^ z);
            }
            y = data[0];
            z = data[n - 1] += (z >> 5 ^ y << 2) + (y >> 3 ^ z << 4)
                    ^ (sum ^ y) + (key[(int) (p & 3 ^ e)] ^ z);
        }
 
        return data;
    }
 
    private static long[] TEADecrypt(long[] data, long[] key) {
        int n = data.length;
        if (n < 1) {
            return data;
        }
 
        long z = data[data.length - 1], y = data[0], sum = 0, e, p, q;
        q = 6 + 52 / n;
        sum = q * DELTA;
        while (sum != 0) {
            e = (sum >> 2) & 3;
            for (p = n - 1; p > 0; p--) {
                z = data[(int) (p - 1)];
                y = data[(int) p] -= (z >> 5 ^ y << 2) + (y >> 3 ^ z << 4)
                        ^ (sum ^ y) + (key[(int) (p & 3 ^ e)] ^ z);
            }
            z = data[n - 1];
            y = data[0] -= (z >> 5 ^ y << 2) + (y >> 3 ^ z << 4) ^ (sum ^ y)
                    + (key[(int) (p & 3 ^ e)] ^ z);
            sum -= DELTA;
        }
 
        return data;
    }
 
    private static long[] ToLongArray(byte[] data) {
        int n = (data.length % 8 == 0 ? 0 : 1) + data.length / 8;
        long[] result = new long[n];
 
        for (int i = 0; i < n - 1; i++) {
            result[i] = bytes2long(data, i * 8);
        }
 
        byte[] buffer = new byte[8];
        for (int i = 0, j = (n - 1) * 8; j < data.length; i++, j++) {
            buffer[i] = data[j];
        }
        result[n - 1] = bytes2long(buffer, 0);
 
        return result;
    }
 
    private static byte[] ToByteArray(long[] data) {
        List<Byte> result = new ArrayList<Byte>();
 
        for (int i = 0; i < data.length; i++) {
            byte[] bs = long2bytes(data[i]);
            for (int j = 0; j < 8; j++) {
                result.add(bs[j]);
            }
        }
 
        while (result.get(result.size() - 1) == SPECIAL_CHAR) {
            result.remove(result.size() - 1);
        }
 
        byte[] ret = new byte[result.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = result.get(i);
        }
        return ret;
    }
 
    public static byte[] long2bytes(long num) {
        ByteBuffer buffer = ByteBuffer.allocate(8).order(
                ByteOrder.LITTLE_ENDIAN);
        buffer.putLong(num);
        return buffer.array();
    }
 
    public static long bytes2long(byte[] b, int index) {
        ByteBuffer buffer = ByteBuffer.allocate(8).order(
                ByteOrder.LITTLE_ENDIAN);
        buffer.put(b, index, 8);
        return buffer.getLong(0);
    }
 
    private static String ToHexString(long[] data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(PadLeft(Long.toHexString(data[i]), 16));
        }
        return sb.toString();
    }
 
    private static long[] ToLongArray(String data) {
        int len = data.length() / 16;
        long[] result = new long[len];
        for (int i = 0; i < len; i++) {
            result[i] = new BigInteger(data.substring(i * 16, i * 16 + 16), 16)
                    .longValue();
        }
        return result;
    }
 
    private static String PadRight(String source, int length) {
        while (source.length() < length) {
            source += SPECIAL_CHAR;
        }
        return source;
    }
 
    private static String PadLeft(String source, int length) {
        while (source.length() < length) {
            source = '0' + source;
        }
        return source;
    }
 
    private static long DELTA = 2654435769L;
    private static int MIN_LENGTH = 32;
    private static char SPECIAL_CHAR = '\0';
    private static String KEY = "tydic.com";
    public static void main(String[] args) {
    	System.out.println(TeaUtil.Decrypt("5df89a95dbb386663bb0a357b0a0b6e5a4ab9fafd39aacc7c3aafdcd1db78500"));
	}
}
