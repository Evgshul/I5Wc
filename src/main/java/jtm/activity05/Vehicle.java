package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Vehicle extends Transport {
	protected int wheels;

	public Vehicle(String id, float consumption, int tankSize, int wheels) {
		super(id, consumption, tankSize);
		this.wheels = wheels;
		
	}

	@Override
	public String move(Road road) {
		
		if(road.getClass() == Road.class){
			String s = super.move(road);
			s.replace("moving", "driving");		
			return s.replace("moving", "driving") + " with "+ wheels +" wheels";}
		
		else return "Cannot drive on " + road.toString();
	}
	

}
