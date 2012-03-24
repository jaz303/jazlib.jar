package com.onehackoranother.cyclone;

import com.onehackoranother.math.Vec3f;

public class Particle {
    protected Vec3f position;
    protected Vec3f velocity;
    protected Vec3f acceleration;
    float damping;
    float inverseMass;
    
    public Vec3f getPosition() { return position; }
    public Vec3f getVelocity() { return velocity; }
    public Vec3f getAcceleration() { return acceleration; }
    public float getDamping() { return damping; }
    public float getInverseMass() { return inverseMass; }
    
    public float getMass() {
        if (inverseMass == 0.0f) {
            return Float.POSITIVE_INFINITY;
        } else {
            return 1.0f / inverseMass;
        }
    }
    
    public boolean hasFiniteMass() { return inverseMass > 0.0f; }
    public boolean hasInfiniteMass() { return inverseMass == 0.0f; }
    
    public void setPosition(Vec3f p) { this.position = p; }
    public void setPosition(float x, float y, float z) {
        this.position.x = x;
        this.position.y = y;
        this.position.z = z;
    }
    
    public void setVelocity(Vec3f v) { this.velocity = v; }
    public void setVelocity(float x, float y, float z) {
        this.velocity.x = x;
        this.velocity.y = y;
        this.velocity.z = z;
    }
    
    public void setAcceleration(Vec3f a) { this.acceleration = a; }
    public void setAcceleration(float x, float y, float z) {
        this.acceleration.x = x;
        this.acceleration.y = y;
        this.acceleration.z = z;
    }
    
    public void setDamping(float d) { this.damping = 0.0f; }
    public void setInverseMass(float im) { this.inverseMass = im; }
    public void setMass(float m) { this.inverseMass = 1.0f / m; }
    public void setInfiniteMass() { this.inverseMass = 0.0f; }
    
    public void integrate(float delta) {
        
        if (inverseMass <= 0.0f) return;
        
        position._add(velocity, delta);
        
        Vec3f resultingAcc = new Vec3f();
        resultingAcc.x = acceleration.x;
        resultingAcc.y = acceleration.y;
        resultingAcc.z = acceleration.z;
        
        velocity._add(resultingAcc, delta);
        velocity._mul((float) Math.pow(damping, delta));
        
        clearAccumulator();
        
    }
    
    protected void clearAccumulator() {
        
    }
}
