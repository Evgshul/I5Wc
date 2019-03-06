package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Amphibia extends Transport {
	private byte sails;
	private int wheels;

	public Amphibia(String id, float consumption, int tankSize, byte sails, int wheels) {
		
		super(id,consumption,tankSize,0);
		this.sails=sails;
		this.wheels=wheels;
	}

	@Override
	public String move(Road road) {
		
		return ;
	}
	
	

}
