package com.onehackoranother.responsecurve;

public class ResponseCurves {
    public static ResponseCurve clampInMin(ResponseCurve curve, float min) {
        return clampIn(curve, min, Float.POSITIVE_INFINITY);
    }
    
    public static ResponseCurve clampInMax(ResponseCurve curve, float max) {
        return clampIn(curve, Float.NEGATIVE_INFINITY, max);
    }
    
    public static ResponseCurve clampIn(ResponseCurve curve, float min, float max) {
        return new ClampInResponseCurve(curve, min, max);
    }
    
    public static ResponseCurve clampOutMin(ResponseCurve curve, float min) {
        return clampOut(curve, min, Float.POSITIVE_INFINITY);
    }
    
    public static ResponseCurve clampOutMax(ResponseCurve curve, float max) {
        return clampOut(curve, Float.NEGATIVE_INFINITY, max);
    }
    
    public static ResponseCurve clampOut(ResponseCurve curve, float min, float max) {
        return new ClampOutResponseCurve(curve, min, max);
    }
}
