package com.onehackoranother.alg.astar;

import java.util.Iterator;

public class Engine<T> {

	
	private Map<T>					map;
	private Heuristic<T>			heuristic;
	private Storage<T>				storage;
	
	public Engine(Map<T> m, Heuristic<T> h, Storage<T> s) {
		map			= m;
		heuristic	= h;
		storage		= s;
	}
	
	public Engine(Map<T> m, Heuristic<T> h) {
		this(m, h, new DefaultStorage<T>());
	}
	
	public Heuristic<T> getHeuristic() { return heuristic; }
	public void setHeuristic(Heuristic<T> h) { heuristic = h; }
	
	public void calculate(T start, T goal) {
		
		storage.reset(map);
		storage.addToOpenSet(start, 0.0f, heuristic.estimateDistance(start, goal));
		
		while (storage.hasOpenNodes()) {
			T curr = storage.removeBestOpenNode();
			if (curr == goal) {
				// done, calculate path
			} else {
				storage.addToClosedSet(curr);
				
				int neighbourIx = 0;
				Iterator<T> neighbours = map.getNeighbourIterator(curr);
				while (neighbours.hasNext()) {
					T neighbour = neighbours.next();
					if (storage.isInClosedSet(neighbour)) {
						continue;
					}
					
					float tentativeG = storage.g(curr) + map.distance(curr, neighbour, neighbourIx);
					boolean tentativeIsBetter = true;
					
					if (!storage.isInOpenSet(neighbour)) {
						storage.addToOpenSet(neighbour, heuristic.estimateDistance(neighbour, goal));
					} else if (tentativeG > storage.g(neighbour)) {
						tentativeIsBetter = false;
					}
					
					if (tentativeIsBetter) {
						// set neighbour's parent to current
						// set neighbour's g to tentative g
						// set neighbour's f to g + h
					}
					
					++neighbourIx;
				} 
			}
		}
		
	}
}
