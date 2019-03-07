package jtm.activity05;

import jtm.activity04.Road;

public class WaterRoad extends Road {
	private Road road;

	public WaterRoad(String from, String to, int distance) {
		super(from, to, distance);
		// TODO Auto-generated constructor stub
	}

	public WaterRoad() {
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Water Road from "+ road.getFrom() +"—"+ road.getTo() + ", "+ road.getDistance() + "km";
		
	}

	
}
