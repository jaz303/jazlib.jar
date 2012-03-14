package com.onehackoranother.alg.astar;

public interface Storage<T> {
	public void reset(Map<T> map);
	public boolean hasOpenNodes();
	public T removeBestOpenNode();
	public void addToClosedSet(T node);
	public void addToOpenSet(T node, float h);
	public void addToOpenSet(T node, float g, float h);
	public boolean isInClosedSet(T node);
	public boolean isInOpenSet(T node);
	public float f(T Node);
	public float g(T Node);
	public float h(T Node);
}
