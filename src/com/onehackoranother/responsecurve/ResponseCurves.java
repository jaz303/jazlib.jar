package com.onehackoranother.responsecurve;

import com.onehackoranother.math.FloatFunction;

public class ResponseCurves {
    public static FloatFunction clampInMin(FloatFunction curve, float min) {
        return clampIn(curve, min, Float.POSITIVE_INFINITY);
    }
    
    public static FloatFunction clampInMax(FloatFunction curve, float max) {
        return clampIn(curve, Float.NEGATIVE_INFINITY, max);
    }
    
    public static FloatFunction clampIn(FloatFunction curve, float min, float max) {
        return new ClampInResponseCurve(curve, min, max);
    }
    
    public static FloatFunction clampOutMin(FloatFunction curve, float min) {
        return clampOut(curve, min, Float.POSITIVE_INFINITY);
    }
    
    public static FloatFunction clampOutMax(FloatFunction curve, float max) {
        return clampOut(curve, Float.NEGATIVE_INFINITY, max);
    }
    
    public static FloatFunction clampOut(FloatFunction curve, float min, float max) {
        return new ClampOutResponseCurve(curve, min, max);
    }
}
