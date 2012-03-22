package com.onehackoranother.responsecurve;

public class ClampInResponseCurve implements ResponseCurve {
    private final ResponseCurve clamped;
    private final float min;
    private final float max;
    
    public ClampInResponseCurve(ResponseCurve clamped, float min, float max) {
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
