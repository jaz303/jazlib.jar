package com.onehackoranother.alg.astar;

public interface Heuristic<T> {
	public float estimateDistance(T node, T goal);
}
