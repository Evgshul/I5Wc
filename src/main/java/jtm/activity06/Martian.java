package jtm.activity06;

public class Martian implements Alien, Cloneable, Humanoid {
	
	private int weight;
	private Object backpack;
	
	

	public Martian(int weight) {
		
		this.weight = weight;
	}

	@Override
	public String killHimself() {
		// TODO Auto-generated method stub
		return "I AM IMMORTAL!";
	}

	@Override
	public int getArmCount() {
		// TODO Auto-generated method stub
		return 	ARM_COUNT;
	}

	@Override
	public void setBackpack(String item) {
		this.backpack=item;

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
	public void eatHuman(Humanoid humanoid) {
		
		if(humanoid instanceof Human){
			if(humanoid.isAlive()=="Alive"){
				humanoid.killHimself();
			this.weight+=humanoid.getWeight();
		}
	}

	}

	@Override
	public int getLegCount() {
		
		return LEG_COUNT;
	}

	@Override
	public Object getBackpack() {
		
		return clone(backpack);
	}

	@Override
	public void setBackpack(Object item) {
         if(item!=this) backpack=item;		

	}

	@Override
	public String isAlive() {
		
		return null;
	}
	
	@Override
	public String toString() {
	    return this.getClass().getSimpleName() + weight + " [" + backpack + "]";
	}
	@Override
    public Object clone() throws CloneNotSupportedException {
				
    return clone(this);
}
	private Object clone(Object current) {
		   if (current instanceof Human) {
               Human h = (Human) current;
               Human hm = new Human(h.getWeight());
               String src = h.getBackpack();
               String tmp = null;
               if (src != null)
                       tmp = new String(src);
               hm.setBackpack(tmp);
               return hm;
       }

       if (current instanceof Martian) {
               Martian m = (Martian) current;
               Martian mt = new Martian(m.getWeight());
               mt.setBackpack(m.getBackpack());
               return mt;
       }

      if (current instanceof String) {
               return new String((String)(current));
       }

       if (current instanceof Object) {
               return new Object();
       }

		return null;
		
	  
	}
	
}
