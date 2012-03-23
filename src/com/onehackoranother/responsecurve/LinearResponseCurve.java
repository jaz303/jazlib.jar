package com.onehackoranother.responsecurve;

import com.onehackoranother.math.FloatFunction;

public class LinearResponseCurve implements FloatFunction {
    private float x, y, m;
    
    public LinearResponseCurve(float x1, float y1, float x2, float y2) {
        this.x = x1;
        this.y = y1;
        this.m = (x2 - x1) / (y2 - y1);
    }
    
    public LinearResponseCurve(float x, float y, float m) {
        this.x = x;
        this.y = y;
        this.m = m;
    }
    
    public float value(float v) {
        return y + (v - x) * m;
    }
}
