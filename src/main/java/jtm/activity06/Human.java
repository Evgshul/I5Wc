package jtm.activity06;

public class Human implements Humanoid {
	
	private String backpack;
	boolean isAlive = true;
	private int weight;
	
	
	

	public Human() {
	
		weight = 42;
	}
	
	public Human(int weight){
		this.weight=weight;
	}

	@Override
	public int getWeight() {
		
		return weight;
	}

	@Override
	public void setWeight(int weight) {
		this.weight=weight;
		

	}

	@Override
	public String killHimself() {
		
		isAlive=false;
		
		return isAlive();
	}

	@Override
	public int getArmCount() {
		
		return ARM_COUNT;
	}

	@Override
	public String getBackpack() {
		
		return backpack;
	}

	@Override
	public void setBackpack(String item) {
		this.backpack=item;
		
		

	}

	@Override
	public String isAlive() {
		// TODO Auto-generated method stub
		if(isAlive==true)return "Alive";
		else
		return "Dead";
	}

	@Override
	public String toString() {
	    return this.getClass().getSimpleName() + weight + " [" + backpack + "]";
	}
}
