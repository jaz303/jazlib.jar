package com.onehackoranother.math;

public class Vec2f {
    public float x;
    public float y;
    
    public Vec2f() {
        this.x = 0.0f;
        this.y = 0.0f;
    }
    
    public Vec2f(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public Vec2f(Vec2f v) {
        this.x = v.x;
        this.y = v.y;
    }
    
    //
    // Non-destructive
    
    public Vec2f add(Vec2f r) { return new Vec2f(x + r.x, y + r.y); }
    public Vec2f sub(Vec2f r) { return new Vec2f(x - r.x, y - r.y); }
    public Vec2f mul(float r) { return new Vec2f(x * r, y * r); }
    public Vec2f div(float r) { return new Vec2f(x / r, y / r); }
    
    public Vec2f normalise() {
        float m = magnitude();
        return new Vec2f(x / m, y / m);
    }
    
    public Vec2f limit(float max) {
        float m = magnitude();
        if (m > max) {
            float div = m / max;
            return new Vec2f(x / div, y / div);
        } else {
            return this;
        }
    }
    
    //
    // Destructive
    
    public Vec2f _add(Vec2f r) { x += r.x; y += r.y; return this; }
    public Vec2f _sub(Vec2f r) { x -= r.x; y -= r.y; return this; }
    public Vec2f _mul(float r) { x *= r; y *= r; return this; }
    public Vec2f _div(float r) { x /= r; y /= r; return this; }
    
    public Vec2f _normalise() {
        float m = magnitude();
        x /= m; y /= m;
        return this;
    }
    
    public Vec2f _limit(float max) {
        float m = magnitude();
        if (m > max) {
            float div = m / max;
            x /= div;
            y /= div;
        }
        return this;
    }
    
    //
    //
    
    public float magnitudeSquared() {
        return x * x + y * y;
    }
    
    public float magnitude() {
        return (float) Math.sqrt(x * x + y * y);
    }
    
    public float distanceSquared(Vec2f r) {
        return (r.x - x) * (r.x - x) + (r.y - y) * (r.y - y);
    }
    
    public float distance(Vec2f r) {
        return (float) Math.sqrt((r.x - x) * (r.x - x) + (r.y - y) * (r.y - y));
    }
    
    public float dot(Vec2f r) {
        return x * r.x + y * r.y;
    }
    
    public String toString() {
        return "<" + x + "," + y + ">";
    }
    
    // angle
}
