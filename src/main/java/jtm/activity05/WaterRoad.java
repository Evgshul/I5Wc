package jtm.activity05;

import jtm.activity04.Road;

public class WaterRoad extends Road {
	//private Road road;

	public WaterRoad(String from, String to, int distance) {
		super(from, to, distance);
		
	}

	public WaterRoad() {
		
	}

	@Override
	public String toString() {
		
		return this.getClass().getSimpleName() + " "+super.toString();
		
	}

	
}
