public class Main {
	
	public static void main(String[] args) {
		
		int[] array = {1,2,3,5,5,8,9};
		int[] values = {1,2,3,4,5,6,7,8,9};
		int[] frequencies = {1,1,1,0,2,0,0,1,1};
		
		GraphWindow testGraphWindow = new GraphWindow(values, frequencies);	
		testGraphWindow.getThisFrame();
	}
}