package com.onehackoranother.alg.astar;

import java.util.Iterator;

public interface Map<T> {

    /**
     * Returns the distance between <tt>node</tt> and <tt>neighbour</tt>.
     * Behaviour is undefined if <tt>neighbour</tt> is not an immediate
     * neighbour of <tt>node</tt>.
     * 
     * @param node
     * @param neighbour
     * @param ix
     *            index of <tt>neighbour</tt> within <tt>node</tt>'s neighbour
     *            iterator (useful for optimisation).
     * @return
     */
    public float distance(T node, T neighbour, int ix);

    /**
     * Returns an iterator over the given node's children. The A* engine is
     * guaranteed to never iterate recursively so it is permitted for a
     * <tt>Map</tt> to implement its own iterator (e.g. return this)
     * 
     * @param node
     * @return
     */
    public Iterator<T> getNeighbourIterator(T node);
}
