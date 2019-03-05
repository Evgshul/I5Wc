package jtm.activity04;

public class Road {
	private String from; // Start point
	private String to; // End point
	private int distance; // distance in km
	
	
	
	/*- TODO #1
	 * Select menu Source — Generate Constructor using Fields...
	 * and create constructor which sets from, to and distance
	 * values of the newly created object
	 */
	public Road(String from, String to, int distance) {
		super();
		this.from = from;
		this.to = to;
		this.distance = distance;
	}
	
	/*- TODO #2
	 * Create constructor without parameters, which sets empty
	 * values or 0 to all object properties
	 */
     public Road(){
        this.from = "";
        this.to = "";
        this.distance=0;
     }

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	/*- TODO #3
	 * Select menu: Source — Generate getters and Setters...
	 * and generate public getters/setters for distance, from and to
	 * fields
	 */
public String toString(){
	return "From " + from + " To, " + to + distance;
}

	/*- TODO #4
	 * Select menu: Source — Generate toString()...
	 * and implement this method, that it returns String in form:
	 * "From — To, 00km"
	 * Note that — is not dash ("minus key" in jargon), but m-dash!
	 * See more at: https://en.wikipedia.org/wiki/Dash
	 */


}
