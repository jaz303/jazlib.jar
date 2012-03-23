package com.onehackoranother.responsecurve;

import com.onehackoranother.math.FloatFunction;

// Based on the 'The Beauty of Response Curves' by Bob Alexander
// As found in AI Game Programming Wisdom (vol. 1)
public class ArrayResponseCurve implements FloatFunction {
    
    private float       min;
    private float[]     samples;
    private float       step;
    
    public ArrayResponseCurve(float min, float max, int numSamples, FloatFunction sampler) {
        this.min    = min;
        samples     = new float[numSamples];
        step        = (max - min) / numSamples;
        
        for (int i = 0; i < numSamples; i++) {
            samples[i] = sampler.value(min + (i * step));
        }
    }
    
    public ArrayResponseCurve(float min, float max, float[] samples) {
        this.min        = min;
        this.samples    = samples;
        this.step       = (max - min) / samples.length;
    }
    
    public float value(float v) {
        int bi = (int) Math.floor((v - min) / step);
        
        if (bi <= 0) {
            return samples[0];
        } else if (bi >= samples.length) {
            return samples[samples.length - 1];
        }
        
        float t = (v - (bi * step)) / step;
        return ((1 - t) * samples[bi]) + (t * samples[bi + 1]);
    }

}
