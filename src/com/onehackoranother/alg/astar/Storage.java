package com.onehackoranother.alg.astar;

public interface Storage<T> {
    
    /**
     * Reset this <tt>Storage</tt> for a new A* search
     * @param map map to be searched
     */
    public void reset(Map<T> map);

    /**
     * Returns true if there are any nodes in the open set, false otherwise
     * @return true if there are any nodes in the open set, false otherwise
     */
    public boolean hasOpenNodes();

    /**
     * Remove the node having the best f-value from the open set.
     * @return
     */
    public T removeBestOpenNode();

    /**
     * Add a node to the closed set. Calling this method does not automatically
     * remove <tt>node</tt> from the open set.
     * @param node
     */
    public void addToClosedSet(T node);

    /**
     * Add a node to the open set, with initial scores and parent node.
     * @param node
     * @param g
     * @param h
     * @param parent
     */
    public void addToOpenSet(T node, float g, float h, T parent);

    /**
     * Returns true if <tt>node</tt> exists in the closed set, false otherwise.
     * @param node
     * @return
     */
    public boolean isInClosedSet(T node);

    /**
     * Returns true if <tt>node</tt> exists in the open set, false otherwise.
     * @param node
     * @return
     */
    public boolean isInOpenSet(T node);

    /**
     * Returns the g-value for the given node.
     * @param node
     * @return
     */
    public float g(T node);
    
    /**
     * Update the g-value for a given node, iff the given g value is better than
     * that currently stored for the node.
     * @param node
     * @param g
     * @param parent
     */
    public void updateG(T node, float g, T parent);
    
    /**
     * Return a result object to the given node
     * @param node
     * @param returnPath true if the path should be calculated
     * @return
     */
    public Result<T> resultTo(T node, boolean returnPath);
}
