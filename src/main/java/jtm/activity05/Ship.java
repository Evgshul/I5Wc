package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Ship extends Transport {
	
	
	
	protected byte sails;

	
	public Ship(String id, byte sails){
		super(id,0.0F,0,0.0F);
		this.sails=sails;
	}


	@Override
	public String move(Road road) {
		// TODO Auto-generated method stub
		return super.getId() + " Ship is sailing on " + road.getClass().getSimpleName() + "whith" + sails + " sails " ;
	}
	
	

	
	
}
