package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Amphibia extends Transport {
	
	private byte sails;
	private int wheels;

	public Amphibia(String id, float consumption, int tankSize, byte sails, int wheels) {
		
		super(id,consumption,tankSize);
		this.sails=sails;
		this.wheels=wheels;
	}

	@Override
	public String move(Road road) {
		
		if(road.getClass() == Road.class){
		String s = super.move(road);
		s.replace("moving", "driving");		
		return s.replace("moving", "driving") + " with "+ wheels + " wheels";
		}
		
		if(road instanceof WaterRoad)
		return this.getId() + " Amphibia is sailing on " + road.toString() + " with " + sails + " sails";
		else return null;
	}
	
		
}
