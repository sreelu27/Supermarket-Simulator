package concurrent.utility;
////***************Authors: Sreelekshmi Geetha & Sultan Hydrali********************
import java.util.Random;
//utility class
public class GenerateRandomNumbers {
	public int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	public double getRandomNumberInRange(double min, double max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextDouble()*(max-min) + min;
	}

}
