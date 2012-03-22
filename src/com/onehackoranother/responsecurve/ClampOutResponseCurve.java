package com.onehackoranother.responsecurve;

public class ClampOutResponseCurve implements ResponseCurve {
    private final ResponseCurve clamped;
    private final float min;
    private final float max;
    
    public ClampOutResponseCurve(ResponseCurve clamped, float min, float max) {
        this.clamped = clamped;
        this.min = min;
        this.max = max;
    }
    
    @Override
    public float value(float v) {
        float out = clamped.value(v);
        if (out < min) out = min;
        else if (out > max) out = max;
        return out;
    }
}
