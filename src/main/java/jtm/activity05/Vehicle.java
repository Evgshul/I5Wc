package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Vehicle extends Transport {
	protected int wheels;

	public Vehicle(String id, float consumption, int tankSize, int wheels) {
		super(id, consumption, tankSize, 0);
		this.wheels = wheels;
		
	}

	@Override
	public String move(Road road) {
		// TODO Auto-generated method stub
		return this.getId()+" Vehicle is driving on " + road.getClass().getSimpleName() + " whith "+ wheels +" wheels ";
	}
	
	

}
