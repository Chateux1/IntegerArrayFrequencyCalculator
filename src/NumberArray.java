import java.util.Arrays;

public class NumberArray {
	
	private int[] values, frequencies, originalArray;
	private int numberOfValues;
	
	private void setEmptyInputArray() {
		for (int i = 0; i < getNumberOfValues(); i++) {
			setValue(i, i);
			setFrequency(i, 0);
		}
	}
	
	private void setOriginalArray(int[] input) {
		numberOfValues = Arrays.stream(input).max().getAsInt()+1;
		for (int i = 0; i < input.length; i++) {
			originalArray[i] = input[i];
		}
	}
	
	private int getOriginalArrayValue(int i) {
		return originalArray[i];
	}
	
	private int getOriginalArrayLength() {
		return originalArray.length;
	}
	
	public int getNumberOfValues() {
		return numberOfValues;
	}
	
	private void setValue(int valueIndex, int valueToSet) {
		values[valueIndex] = valueToSet;
	}
	
	public int getValue(int i) {
		return values[i];
	}
	
	public int[] getValues() {
		return values;
	}
	
	private void setFrequency(int valueIndex, int valueToSet) {
		frequencies[valueIndex] = valueToSet;
	}
	private void setIncreaseFrequency(int valueIndex) {
		frequencies[valueIndex]++;
	}
	
	public int getFrequency(int i) {
		return frequencies[i];
	}
	
	public int[] getFrequencies() {
		return frequencies;
	}
	
	private void setFrequencies() {
        for (int i = 0; i < getOriginalArrayLength(); i++) {
            int indexFromValue = getOriginalArrayValue(i);
            setIncreaseFrequency(indexFromValue);
        }
	}
	
	public NumberArray(int[] numberArray) {
		originalArray = new int[numberArray.length];
		setOriginalArray(numberArray);
		values = new int[getNumberOfValues()];
		frequencies = new int[getNumberOfValues()];
		setEmptyInputArray();
		setFrequencies();
	}	
}