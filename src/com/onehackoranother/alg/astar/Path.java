package com.onehackoranother.alg.astar;

public interface Path<T> {
    public T getNode();
    public Path<T> nextPathEntry();
}
