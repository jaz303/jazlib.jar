package com.onehackoranother.color;

import static com.onehackoranother.math.Util.clampf;

public class RGBAColor implements AlphaColor {
    private float red;
    private float green;
    private float blue;
    private float alpha;
    
    public RGBAColor(float r, float g, float b, float a) {
        red     = r;
        green   = g;
        blue    = b;
        alpha   = a;
    }
    
    public RGBAColor(float r, float g, float b) {
        red     = r;
        green   = g;
        blue    = b;
        alpha   = 1.0f;
    }
    
    public RGBAColor() {
        red     = 0.0f;
        green   = 0.0f;
        blue    = 0.0f;
        alpha   = 1.0f;
    }
    
    public float getRed() { return red; }
    public float getGreen() { return green; }
    public float getBlue() { return blue; }
    public float getAlpha() { return alpha; }
    
    public void setRed(float r) { red = clampf(r, 0, 1); }
    public void setGreen(float g) { green = clampf(g, 0, 1); }
    public void setBlue(float b) { blue = clampf(b, 0, 1); }
    public void setAlpha(float a) { alpha = clampf(a, 0, 1); }
    
    public int toIntARGB() {
        return ((int)(alpha * 255) << 24)
                | ((int)(red * 255) << 16)
                | ((int)(green * 255) << 8)
                | ((int)(blue * 255) << 0);
    }
}
