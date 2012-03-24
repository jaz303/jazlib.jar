package com.onehackoranother.math;

public class Vec3f {
 
    public boolean orthonormalBasis(Vec3f a, Vec3f b, Vec3f c) {
       
        c.x = a.y * b.z - a.z * b.y;
        c.y = a.z * b.x - a.x * b.z;
        c.z = a.x * b.y - a.y * b.x;
        
        if (c.magnitudeSquared() == 0) {
            return false;
        }
        
        c._normalise();
        
        b.x = c.y * a.z - c.z * a.y;
        b.y = c.z * a.x - c.x * a.z;
        b.z = c.x * a.y - c.y * a.x;
        
        return true;
    
    }
    
    public float x;
    public float y;
    public float z;
    
    public Vec3f() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
    }
    
    public Vec3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Vec3f(Vec3f v) {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }
    
    //
    // Non-destructive
    
    public Vec3f add(Vec3f r) { return new Vec3f(x + r.x, y + r.y, z + r.z); }
    public Vec3f add(Vec3f r, float scale) { return new Vec3f(x + r.x * scale, y + r.y * scale, z + r.z * scale); }
    public Vec3f sub(Vec3f r) { return new Vec3f(x - r.x, y - r.y, z - r.z); }
    public Vec3f mul(float r) { return new Vec3f(x * r, y * r, z * r); }
    public Vec3f mul(Vec3f r) { return new Vec3f(x * r.x, y * r.y, z * r.z); }
    public Vec3f div(float r) { return new Vec3f(x / r, y / r, z / r); }
    public Vec3f invert() { return new Vec3f(-x, -y, -z); }
    public Vec3f cross(Vec3f r) { return new Vec3f(y * r.z - z * r.y, z * r.x - x * r.z, x * r.y - y * r.x); }
    
    public Vec3f normalise() {
        float m = magnitude();
        if (m > 0) {
            return new Vec3f(x / m, y / m, z /m);
        } else {
            return this;
        }
    }
    
    public Vec3f limit(float max) {
        float m = magnitude();
        if (m > max) {
            float div = m / max;
            return new Vec3f(x / div, y / div, z / div);
        } else {
            return this;
        }
    }
    
    //
    // Destructive
    
    public void _add(Vec3f r) { x += r.x; y += r.y; z += r.z; }
    public void _add(Vec3f r, float scale) { x += r.x * scale; y += r.y * scale; z += r.z * scale; }
    public void _sub(Vec3f r) { x -= r.x; y -= r.y; z -= r.z; }
    public void _mul(float r) { x *= r; y *= r; z *= r; }
    public void _mul(Vec3f r) { x *= r.x; y *= r.y; z *= r.z; }
    public void _div(float r) { x /= r; y /= r; z /= r; }
    public void _invert() { x = -x; y = -y; z = -z; }
    
    public void _cross(Vec3f r) {
        float x2 = y * r.z - z * r.y;
        float y2 = z * r.x - x * r.z;
        float z2 = x * r.y - y * r.x;
        x = x2;
        y = y2;
        z = z2;
    }
    
    public void _normalise() {
        float m = magnitude();
        if (m > 0) {
            x /= m; y /= m; z /= m;
        }
    }
    
    public void _limit(float max) {
        float m = magnitude();
        if (m > max) {
            float div = m / max;
            x /= div;
            y /= div;
            z /= div;
        }
    }
    
    //
    //
    
    public float magnitudeSquared() {
        return x * x + y * y + z * z;
    }
    
    public float magnitude() {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }
    
    public float distanceSquared(Vec3f r) {
        return (r.x - x) * (r.x - x) + (r.y - y) * (r.y - y) + (r.z - z) * (r.z - z);
    }
    
    public float distance(Vec3f r) {
        return (float) Math.sqrt((r.x - x) * (r.x - x) + (r.y - y) * (r.y - y) + (r.z - z) * (r.z - z));
    }
    
    public float dot(Vec3f r) {
        return x * r.x + y * r.y + z * r.z;
    }
    
    public String toString() {
        return "<" + x + "," + y + "," + z + ">";
    }
}
