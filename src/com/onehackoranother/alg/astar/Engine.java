package com.onehackoranother.alg.astar;

import java.util.Iterator;

public class Engine<T> {

    private Map<T> map;
    private Heuristic<T> heuristic;
    private Storage<T> storage;

    public Engine(Map<T> m, Heuristic<T> h, Storage<T> s) {
        map = m;
        heuristic = h;
        storage = s;
    }

    public Engine(Map<T> m, Heuristic<T> h) {
        this(m, h, new DefaultStorage<T>());
    }

    public Heuristic<T> getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(Heuristic<T> h) {
        heuristic = h;
    }
    
    public Result<T> calculate(T start, T goal) {
        return doAStar(start, goal, true);
    }
    
    public Path<T> calculatePath(T start, T goal) {
        return doAStar(start, goal, true).path;
    }
    
    public float calculateCost(T start, T goal) {
        return doAStar(start, goal, false).cost;
    }
    
    private Result<T> doAStar(T start, T goal, boolean returnPath) {

        storage.reset(map);
        storage.addToOpenSet(start, 0.0f, heuristic.estimateDistance(start, goal), null);

        while (storage.hasOpenNodes()) {
            T curr = storage.removeBestOpenNode();
            if (curr == goal) {
                return storage.resultTo(goal, returnPath);
            } else {
                storage.addToClosedSet(curr);

                int neighbourIx = 0;
                Iterator<T> neighbours = map.getNeighbourIterator(curr);
                while (neighbours.hasNext()) {
                    
                    T neighbour = neighbours.next();
                    if (storage.isInClosedSet(neighbour)) {
                        continue;
                    }

                    float gScore = storage.g(curr) + map.distance(curr, neighbour, neighbourIx);
                    
                    if (!storage.isInOpenSet(neighbour)) {
                        storage.addToOpenSet(
                                neighbour,
                                gScore,
                                heuristic.estimateDistance(neighbour, goal),
                                curr
                                );
                    } else {
                        storage.updateG(neighbour, gScore, curr);
                    }

                    ++neighbourIx;
                }
            }
        }
        
        return null;

    }
}
