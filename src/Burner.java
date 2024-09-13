/*
 * Burner Class
 * 
 * Authors: Garrison Cook, Deklan Brown
 * 
 * Simulates a burner on a stove
 */
public class Burner {
	private Temperature myTemperature; // What temperature a burner is at
	private Setting mySetting; // What setting a burner is on
	private int timer; // Number value of how long until a burner increases or decreases in temperature
	public static final int TIME_DURATION = 2; // The starting value of the timer when the heat setting is changed
	
	public int tempMax; // Keeps track of how high the temperature of a burner can get to based on the setting
	public int tempNum; // Keeps track of how high the temperature of a burner is currently;
	
	/*
	 * Constructor for Burner class
	 * 
	 * Sets starting temperature of burner to cold
	 * sets starting setting of burner to off
	 * sets tempMax to 0
	 * sets tempNum to 0
	 */
	public Burner() {
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
		tempMax = 0;
		tempNum = 0;
	}
	
	/*
	 * Enumerated Temperature Variable
	 * Keeps track of the temperature of each burner
	 */
	public enum Temperature{
		BLAZING("Blazing"), HOT("Hot"), WARM("Warm"), COLD("Cold");
		private String temp;
		
		/*
		 * Constructor for Temperature
		 * Sets starting temp of stove to the inputed value
		 */
		Temperature (String temp){
			this.temp = temp;
		}
	}
	
	/*
	 * getTemperature function
	 * 
	 * Returns temperature of burner
	 */
	public Temperature getTemperature() {
		return myTemperature;
	}
	
	/*
	 * plusButton function
	 * 
	 * Increases the setting of a burner
	 */
	public void plusButton() {
		timer = TIME_DURATION;
		switch(mySetting) {
			case Setting.OFF:
				mySetting = Setting.LOW;
				tempMax = 1;
				break;
			case Setting.LOW:
				mySetting = Setting.MEDIUM;
				tempMax = 2;
				break;
			case Setting.MEDIUM:
				mySetting = Setting.HIGH;
				System.out.println("Temp max reached 3");
				tempMax = 3;
				break;
			case Setting.HIGH:
				mySetting = Setting.HIGH;
				tempMax = 3;
				System.out.println("Burner already at highest setting");
				break;
		}
	}
	
	/*
	 * minusButton function
	 * 
	 * decreases the setting of a burner
	 */
	public void minusButton() {
		timer = TIME_DURATION;
		switch(mySetting) {
			case Setting.OFF:
				mySetting = Setting.OFF;
				tempMax = 0;
				// System.out.println("Burner already at lowest setting");
				break;
			case Setting.LOW:
				tempMax = 0;
				mySetting = Setting.OFF;
				break;
			case Setting.MEDIUM:
				tempMax = 1;
				mySetting = Setting.LOW;
				break;
			case Setting.HIGH:
				tempMax = 2;
				mySetting = Setting.MEDIUM;
				break;
		}
	}
	
	/*
	 * updateTemperature function
	 * 
	 * sets the burner temperature based on its setting and how long it has been heating up
	 */
	public void updateTemperature() {
		if (timer >= 1) {
			timer = timer - 1;
		}
		if (timer == 0) {
			if (tempNum < tempMax) {
				//System.out.println("tempNum < tempMax: " + tempNum + ", " + tempMax);
				tempNum += 1;
			}
			else if (tempNum > tempMax) {
				tempNum -= 1;
			}
			//System.out.println("tempNum = " + tempNum);
			switch(tempNum) {
				case 0:
					myTemperature = Temperature.COLD;
					break;
				case 1:
					myTemperature = Temperature.WARM;
					break;
				case 2:
					myTemperature = Temperature.HOT;
					break;
				case 3:
					//System.out.println("very hot");
					myTemperature = Temperature.BLAZING;
					break;
			}
			if (tempNum != tempMax && timer == 0) {
				timer = TIME_DURATION;
			}
		}
	}
	
	/*
	 * display function
	 * 
	 * Displays each burner based on its setting and heat level
	 */
	public boolean display() {
		boolean veryHot = false;
		System.out.print("[" + mySetting.toString() + "].....");
		switch(myTemperature) {
			case Temperature.COLD:
				System.out.println("cooool");
				break;
			case Temperature.WARM:
				System.out.println("warm");
				break;
			case Temperature.HOT:
				System.out.println("CAREFUL");
				break;
			case Temperature.BLAZING:
				System.out.println("VERY HOT! DON'T TOUCH");
				veryHot = true;
				break;
		}
		return veryHot;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
