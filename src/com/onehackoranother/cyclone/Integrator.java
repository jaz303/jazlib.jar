package com.onehackoranother.cyclone;

public class Integrator {
    public void integrate(Particle[] particles, float delta) {
        for (int i = 0; i < particles.length; i++) {
            particles[i].integrate(delta);
        }
    }
}
