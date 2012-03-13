package com.onehackoranother.alg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParticleFilter<T> {
	
	public static final Random random = new Random();
	
	public static <T> void filter(T[] in, double[] weights, T[] out) {
		
		if (in.length != out.length || in.length != weights.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		int n		= in.length;
		double maxW	= 0.0f;
		double beta	= 0.0f;
		int index	= random.nextInt(n);
		
		for (double d : weights) {
			if (d > maxW) maxW = d;
		}
		
		for (int i = 0; i < n; i++) {
			beta += random.nextDouble() * 2.0 * maxW;
			while (beta > weights[index]) {
				beta -= weights[index];
				index = (index + 1) % n;
			}
			out[i] = in[index];
		}
		
	}
	
	public static <T> void filter(List<T> in, double[] weights, List<T> out) {
		
		if (in.size() != out.size() || in.size() != weights.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		int n		= in.size();
		double maxW	= 0.0f;
		double beta	= 0.0f;
		int index	= random.nextInt(n);
		
		for (double d : weights) {
			if (d > maxW) maxW = d;
		}
		
		for (int i = 0; i < n; i++) {
			beta += random.nextDouble() * 2.0 * maxW;
			while (beta > weights[index]) {
				beta -= weights[index];
				index = (index + 1) % n;
			}
			out.add(in.get(index));
		}
		
	}
	
	public static <T> List<T> filter(List<T> in, double[] weights) {
		ArrayList<T> out = new ArrayList<T>();
		filter(in, weights, out);
		return out;
	}
	
	
	final int						numParticles;
	final private double[]			weights;
	final private Measurer<T>		measurer;
	
	public ParticleFilter(int n, Measurer<T> m) {
		numParticles	= n;
		weights			= new double[n];
		measurer		= m;
	}
	
	public void measure(T[] in) {
		
		if (in.length != numParticles) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		for (int i = 0; i < numParticles; i++) {
			weights[i] = measurer.measurementProbability(in[i]);
		}
	
	}
	
	public void measure(List<T> in) {
		
		if (in.size() != numParticles) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		int i = 0;
		for (T item : in) {
			weights[i] = measurer.measurementProbability(item);
			i++;
		}
		
	}
	
	public void filter(T[] in, T[] out) {
		filter(in, weights, out);
	}
	
	public void filter(List<T> in, List<T> out) {
		filter(in, weights, out);
	}
	
	public List<T> filter(List<T> in) {
		return filter(in, weights);
	}

}
