package com.onehackoranother.math;

public class Vec2 {
    public float x;
    public float y;
    
    public Vec2() {
        this.x = 0.0f;
        this.y = 0.0f;
    }
    
    public Vec2(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public Vec2(Vec2 v) {
        this.x = v.x;
        this.y = v.y;
    }
    
    //
    // Destructive methods are prefixed with an underscore
    
    public Vec2 _add(Vec2 r) { x += r.x; y += r.y; return this; }
    public Vec2 _sub(Vec2 r) { x -= r.x; y -= r.y; return this; }
    public Vec2 _mul(float r) { x *= r; y *= r; return this; }
    public Vec2 _div(float r) { x /= r; y /= r; return this; }
    
    public Vec2 add(Vec2 r) { return new Vec2(x + r.x, y + r.y); }
    public Vec2 sub(Vec2 r) { return new Vec2(x - r.x, y - r.y); }
    public Vec2 mul(float r) { return new Vec2(x * r, y * r); }
    public Vec2 div(float r) { return new Vec2(x / r, y / r); }
    
    public float distanceSquared(Vec2 r) {
        return (r.x - x) * (r.x - x) + (r.y - y) * (r.y - y);
    }
    
    public float distance(Vec2 r) {
        return (float) Math.sqrt((r.x - x) * (r.x - x) + (r.y - y) * (r.y - y));
    }
    
    // dot
    // angle
    // limit
    // normalise
}
