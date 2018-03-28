package com.gzq.practice.utils;

import java.util.Arrays;

/**
 * 各种位操作级别的工具。
 * 
 * @author GeYi
 *
 */
public class BitUtil {

    /**
     * 将int转换为由高位到低位的byte[]
     * 
     * @param value
     * @return
     */
    public static byte[] intToBytes(int value) {
        byte[] b = new byte[4];
        b[3] = (byte) (value & 0xff);
        b[2] = (byte) ((value >> 8) & 0xff);
        b[1] = (byte) ((value >> 16) & 0xff);
        b[0] = (byte) ((value >>> 24) & 0xff);
        return b;
    }

    /**
     * 将byte[]转换为由高位到低位的int
     * 
     * @param b0
     *            int高位
     * @param b1
     *            int次高位
     * @param b2
     *            int低位
     * @param b3
     *            int最低位
     * @return
     */
    public static int bytesToInt(byte b0, byte b1, byte b2, byte b3) {
//        return ((b0 & 0xff) << 24) | ((b1 & 0xff) << 16) | ((b2 & 0xff) << 8)
//                | (b3 & 0xff);
        return (b0 << 24) | (b1 << 16) | (b2  << 8)
                | (b3 & 0xff);
    }

    public static void main(String[] args) {
        byte[] intToBytes = intToBytes(-1230);
        System.out.println(Arrays.toString(intToBytes));

        int bytesToInt = bytesToInt((byte) -1, (byte) -1, (byte) -5, (byte) 50);
        System.out.println(bytesToInt);
    }
}
