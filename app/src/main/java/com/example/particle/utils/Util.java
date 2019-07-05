package com.example.particle.utils;

import java.util.Random;

/**
 * Created by mysat on 2018/5/14.
 */

public class Util {

    public static double randomV() {
        return Math.random() * 12 - 6;
    }

    public static double randomRV(){
        return Math.random() * 12;
    }

    public static int randomColor() {
        int R = (int) (Math.random() * 255);
        int G = (int) (Math.random() * 255);
        int B = (int) (Math.random() * 255);
        int color = 0, t1, t2;
        color = 15 * (int) Math.pow(16, 7) + 15 * (int) Math.pow(16, 6);
        t1 = R / 16;
        t2 = R % 16;
        color = color + t1 * (int) Math.pow(16, 5) + t2 * (int) Math.pow(16, 4);
        t1 = G / 16;
        t2 = G % 16;
        color = color + t1 * (int) Math.pow(16, 3) + t2 * (int) Math.pow(16, 2);
        t1 = B / 16;
        t2 = B % 16;
        color = color + t1 * (int) Math.pow(16, 1) + t2 * (int) Math.pow(16, 0);
        return color;
    }

    public static int randomRadius() {
        return Math.round((int) (Math.random() * 6)) + 5;
    }

    public static int randomAngle() {
        int min = 1;
        int max = 360;
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }
}
