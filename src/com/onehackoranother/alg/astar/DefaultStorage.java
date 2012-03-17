package com.onehackoranother.alg.astar;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class DefaultStorage<T> implements Storage<T> {

    public class Score implements Path<T> {
        T node;
        Score linked;
        int steps;
        float f, g, h;
        
        public T getNode() { return node; }
        public Path<T> nextPathEntry() { return linked; }
    }

    private class ScoreComparator implements Comparator<Score> {
        @Override
        public int compare(Score l, Score r) {
            float d = l.f - r.f;
            if (d < 0)
                return -1;
            if (d > 0)
                return 1;
            return 0;
        }
    }

    private PriorityQueue<Score> openSet = new PriorityQueue<Score>(128, new ScoreComparator());
    private Set<T> closedSet = new HashSet<T>();
    private java.util.Map<T, Score> scores = new HashMap<T, Score>();

    public DefaultStorage() {

    }

    @Override
    public void reset(Map<T> map) {
        openSet.clear();
        closedSet.clear();
        scores.clear();
    }

    @Override
    public boolean hasOpenNodes() {
        return !openSet.isEmpty();
    }

    @Override
    public T removeBestOpenNode() {
        Score best = openSet.remove();
        return best.node;
    }

    @Override
    public void addToClosedSet(T node) {
        closedSet.add(node);
    }

    @Override
    public void addToOpenSet(T node, float g, float h, T parent) {
        Score s = new Score();
        s.node = node;
        if (parent != null) {
            Score p = scores.get(parent);
            s.linked = p;
            s.steps = p.steps + 1;
        } else {
            s.steps = 0;
        }
        s.f = g + h;
        s.g = g;
        s.h = h;
        scores.put(node, s);
        openSet.add(s);
    }

    @Override
    public boolean isInClosedSet(T node) {
        return closedSet.contains(node);
    }

    @Override
    public boolean isInOpenSet(T node) {
        Score s = scores.get(node);
        return s == null ? false : openSet.contains(s);
    }
    
    @Override
    public float g(T node) {
        return scores.get(node).g;
    }
    
    @Override
    public void updateG(T node, float g, T parent) {
        Score s = scores.get(node);
        if (g < s.g) {
            s.g = g;
            s.f = s.g + s.h;
            Score p = scores.get(parent);
            p.linked = p;
            p.steps = p.steps + 1;
        }
    }
    
    @Override
    public Result<T> resultTo(T node, boolean returnPath) {
        Score curr = scores.get(node);
        
        Result<T> res = new Result<T>();
        res.cost = curr.f;
        res.steps = curr.steps;
        
        if (returnPath) {
            Score head = null;
            while (curr != null) {
                Score next = curr.linked;
                curr.linked = head;
                head = curr;
                curr = next;
            }
            res.path = head;
        }
        
        return res;
    }
}
