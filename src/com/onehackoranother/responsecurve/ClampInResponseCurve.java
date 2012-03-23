package com.onehackoranother.responsecurve;

import com.onehackoranother.math.FloatFunction;

public class ClampInResponseCurve implements FloatFunction {
    private final FloatFunction clamped;
    private final float min;
    private final float max;
    
    public ClampInResponseCurve(FloatFunction clamped, float min, float max) {
        this.clamped = clamped;
        this.min = min;
        this.max = max;
    }
    
    @Override
    public float value(float v) {
        if (v < min) v = min;
        else if (v > max) v = max;
        return clamped.value(v);
    }
}
