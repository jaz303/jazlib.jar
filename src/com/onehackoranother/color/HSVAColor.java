package com.onehackoranother.color;

import static com.onehackoranother.math.Util.clampf;

public class HSVAColor implements AlphaColor {
    private float hue;
    private float saturation;
    private float value;
    private float alpha;
    
    public HSVAColor(float h, float s, float v, float a) {
        this.hue        = h;
        this.saturation = s;
        this.value      = v;
        this.alpha      = a;
    }
    
    public HSVAColor(float h, float s, float v) {
        this.hue        = h;
        this.saturation = s;
        this.value      = v;
        this.alpha      = 1.0f;
    }
    
    public HSVAColor() {
        this.hue        = 0.0f;
        this.saturation = 0.0f;
        this.value      = 0.0f;
        this.alpha      = 1.0f;
    }
    
    public float getHue() { return hue; }
    public float getSaturation() { return saturation; }
    public float getValue() { return value; }
    public float getAlpha() { return alpha; }
    
    public void setHue(float h) { this.hue = clampf(h, 0, 360); }
    public void setSaturation(float s) { this.saturation = clampf(s, 0, 1); }
    public void setValue(float v) { this.value = clampf(v, 0, 1); }
    public void setAlpha(float a) { this.alpha = clampf(a, 0, 1); }
    
    public int toIntARGB() {
        
        float c = value * saturation;
        float h = hue / 60.0f;
        float x = c * (1 - (float)Math.floor((h % 2) - 1));

        float r1 = 0, g1 = 0, b1 = 0;

        if (h < 1) {
            r1 = c;
            g1 = x;
        } else if (h < 2) {
            r1 = x;
            g1 = c;
        } else if (h < 3) {
            g1 = c;
            b1 = x;
        } else if (h < 4) {
            g1 = x;
            b1 = c;
        } else if (h < 5) {
            r1 = x;
            b1 = c;
        } else if (h < 6) {
            r1 = c;
            b1 = x;
        }

        float m = value - c,
              r = r1 + m,
              g = g1 + m,
              b = b1 + m;
                    
        return ((int)(alpha * 255) << 24)
                | ((int)(r * 255) << 16)
                | ((int)(g * 255) << 8)
                | ((int)(b * 255));
        
    }
}
