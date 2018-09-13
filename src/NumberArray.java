import java.util.Arrays;
//import java.awt;
//import javax.swing;

public class NumberArray {
		
		int value;
	    int frequency;

	    public int getValue () {
	        return this.value;
	    }

	    public int getFrequency () {
	        return this.frequency;
	    }

	    public void setup (int value) {
	        this.value = value;
	        this.frequency = 0;
	    }

	    public void setIncrease () {
	        this.frequency++;
	    }
	    public NumberArray() {}
	    
	    public NumberArray(int[] input) {
	    	//input
	        int maxIndex = Arrays.stream(input).max().getAsInt()+1;

	        //Initialise array of input values with 0 frequencies
	        NumberArray[] numberArray = new NumberArray[maxIndex];
	        for (int i = 0; i < maxIndex; i++) {
	            numberArray[i] = new NumberArray();
	            numberArray[i].setup(i);
	        }

	        //loop through input array and get frequencies
	        for (int i = 0; i < input.length; i++) {
	            int indexFromValue = input[i];
	            numberArray[indexFromValue].setIncrease();
	        }

	        //create separate arrays for values and frequencies
	        int[] values = new int[maxIndex]; 
	        int[] frequencies = new int[maxIndex];
	        for (int i = 0; i < maxIndex; i++) {
	            values[i] = numberArray[i].getValue();
	            frequencies[i] = numberArray[i].getFrequency();
	        }

	        //print out results
	        System.out.println(Arrays.toString(input));
	        System.out.println(Arrays.toString(values));
	        System.out.println(Arrays.toString(frequencies));
	    }
}