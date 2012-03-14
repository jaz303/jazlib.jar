package com.onehackoranother.alg.astar;

public interface Path<T> {
    public T getNode();
    public boolean hasNext();
    public Path<T> nextPathEntry();
}
