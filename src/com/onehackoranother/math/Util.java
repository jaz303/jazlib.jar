package com.onehackoranother.math;

public class Util {
    public static float clampf(float v, float min, float max) {
        if (v < min) return min;
        if (v > max) return max;
        return v;
    }
}
