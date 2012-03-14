package com.onehackoranother.alg.astar;

public class Path<Node> {

	public final Node		lastStep;
	public final Path<Node>	previousSteps;
	public final double		totalCost;
	
	public Path(Node start) {
		this(start, null, 0.0);
	}
	
	public Path(Node ls, Path<Node> ps, double tc) {
		lastStep 		= ls;
		previousSteps	= ps;
		totalCost 		= tc;
	}
	
	public Path<Node> add(Node nextNode, double stepCost) {
		return new Path<Node>(nextNode, this, totalCost + stepCost);
	}
	
	class Iterator implements java.util.Iterator<Node> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Node next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	
	}

}
