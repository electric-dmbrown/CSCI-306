/*
 * Enumerated Setting class
 * 
 * Authors: Deklan Brown, Garrison Cook
 * 
 * Used to simulate the heat setting of a burner
 */

/*
 * Enumerated Setting variable
 * 
 * Has 4 heat settings based on how hot you want a burner to be
 */
public enum Setting {
	OFF("---"), LOW("--+"), MEDIUM("-++"), HIGH("+++");
	private String value;
	
	/*
	 * Setting constructor
	 * 
	 * sets the starting setting value to the inputed value
	 */
	Setting(String value){
		this.value = value;
	}
	
	/*
	 * toString function
	 * 
	 * returns the heat setting of a burner in the form of a string
	 */
	public String toString() {
		return value;
	}
}
