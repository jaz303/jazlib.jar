package com.onehackoranother.alg.astar;

public class Result<T> {
    Path<T>     path    = null;
    float       cost;
    int         steps;
    
    public boolean hasPath() { return path != null; }
    
    public Path<T> getPath() { return path; }
    public float getCost() { return cost; }
    public int getStepCount() { return steps; }
}
