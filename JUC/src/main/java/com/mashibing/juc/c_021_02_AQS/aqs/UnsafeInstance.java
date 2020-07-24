package com.mashibing.juc.c_021_02_AQS.aqs;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author zl(952999)
 * @description:
 * @date 2020-07-24 20:07
 */
public class UnsafeInstance {
    public static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(reflectGetUnsafe());
    }
}
