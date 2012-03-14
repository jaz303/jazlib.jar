package com.onehackoranother.alg.astar;

// import java.util.Comparator;

public class DefaultStorage<T> implements Storage<T> {
	
//	private class Score {
//		Score		parent;
//		T			node;
//		float		f, g, h;
//	}
//	
//	private class ScoreComparator implements Comparator<Score> {
//		@Override
//		public int compare(Score l, Score r) {
//			float d = l.f - r.f;
//			if (d < 0) return -1;
//			if (d > 0) return 1;
//			return 0;
//		}
//	}
	

	@Override
	public void reset(Map<T> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasOpenNodes() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T removeBestOpenNode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addToClosedSet(T node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addToOpenSet(T node, float h) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addToOpenSet(T node, float g, float h) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isInClosedSet(T node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInOpenSet(T node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float f(T node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float g(T node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float h(T node) {
		// TODO Auto-generated method stub
		return 0;
	}

}
