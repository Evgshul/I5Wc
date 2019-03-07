package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Amphibia extends Transport {
	private Ship ship;
	private Vehicle vehicle;
	private byte sails;
	private int wheels;

	public Amphibia(String id, float consumption, int tankSize, byte sails, int wheels) {
		
		super(id,consumption,tankSize);
		this.sails=sails;
		this.wheels=wheels;
	}

	@Override
	public String move(Road road) {
		
		if(road.getClass() == Road.class){ return this.getClass().getSimpleName() + "behaves like a" + vehicle.getClass().getSimpleName()+ "on ground road";
		}
		//if(road instanceof WaterRoad)
		else return this.getClass().getSimpleName() + "behaves like a" + ship.getClass().getSimpleName() + "on water road";
	}
	
	

}
