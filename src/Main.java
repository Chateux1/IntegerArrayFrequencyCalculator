import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		
		new MainWindow();
		int[] array = {1,2,2,3,4,4,5,6,6,7,8,8,9};
		NumberArray test = new NumberArray(array);
		System.out.println(Arrays.toString(test.getValues()));
		System.out.println(Arrays.toString(test.getFrequencies()));
		//test comment
	}
}