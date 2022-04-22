package javaLibrary;

import java.util.Random;


public class JavaLibrary {

	
	/**
	 * This class contains generic methods related to java
	 * @author 91834
	 * @return
	 */
	
	public int getRandomNumber() 
	{
		/**
		 * This method generate random number
		 */
		Random ran = new Random();
		//int random = ran.nextInt(500);
		return ran.nextInt(1000);
}
}