package com.onehackoranother.alg.astar;

public class Result<T> {
    Path<T>     path    = null;
    float       cost    = -1.0f;
    int         steps   = -1;
    
    public boolean hasPath() { return path != null; }
    public boolean hasCost() { return cost >= 0.0f; }
    public boolean hasStepCount() { return steps >= 0; }
    
    public Path<T> getPath() { return path; }
    public float getCost() { return cost; }
    public int getStepCount() { return steps; }
}
