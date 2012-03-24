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
    public Vec2f add(Vec2f r, float scale) { return new Vec2f(x + r.x * scale, y + r.y * scale); }
    public Vec2f sub(Vec2f r) { return new Vec2f(x - r.x, y - r.y); }
    public Vec2f mul(float r) { return new Vec2f(x * r, y * r); }
    public Vec2f mul(Vec2f r) { return new Vec2f(x * r.x, y * r.y); }
    public Vec2f div(float r) { return new Vec2f(x / r, y / r); }
    public Vec2f invert() { return new Vec2f(-x, -y); }
    
    public Vec2f normalise() {
        float m = magnitude();
        if (m > 0) {
            return new Vec2f(x / m, y / m);
        } else {
            return this;
        }
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
    
    public void _add(Vec2f r) { x += r.x; y += r.y; }
    public void _add(Vec2f r, float scale) { x += r.x * scale; y += r.y * scale; }
    public void _sub(Vec2f r) { x -= r.x; y -= r.y; }
    public void _mul(float r) { x *= r; y *= r; }
    public void _mul(Vec2f r) { x *= r.x; y *= r.y; }
    public void _div(float r) { x /= r; y /= r; }
    public void _invert() { x = -x; y = -y; }
    
    public void _normalise() {
        float m = magnitude();
        if (m > 0) {
            x /= m; y /= m;
        }
    }
    
    public void _limit(float max) {
        float m = magnitude();
        if (m > max) {
            float div = m / max;
            x /= div;
            y /= div;
        }
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
}
