import java.util.Scanner;

public class Problem5_ArrayTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);	
		
		int sizeOfArray = scn.nextInt();
		long[] array = new long[sizeOfArray];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = scn.nextLong(); 
		}
		
		String command = scn.next();

		while (!command.equals("stop")) {   // stop, not "over" :)
			String line = scn.nextLine().trim();
			int[] params = new int[2];

			if(command.equals("add") || command.equals("subtract") || command.equals("multiply")) {  // was "substract" :D
				String[] stringParams = line.split(" ");
				params[0] = Integer.parseInt(stringParams[0]);
				params[1] = Integer.parseInt(stringParams[1]);

				performAction(array, command, params);
			}
			else if (command.equals("rshift")){
				arrayShiftRight(array);
			}
			else if (command.equals("lshift")){
				arrayShiftLeft(array);
			}
			//performAction(array, command, params); // no need for this


			printArray(array);
			System.out.print('\n');
			
			command = scn.next();			
		}		
	}
	
	static void performAction(long[] arr, String action, int[] params){
		//long[] array = arr.clone(); // if we clone the array and do not return it , there's no point
		int pos = params[0]-1; // the position "i" starts from 1, so we subtract 1
		int value = params[1];

		switch (action) {
		case "multiply":
			arr[pos] *= value;		
			break;
		case "add":
			arr[pos] += value; 
			break;
		case "subtract":
			arr[pos] -= value;
			break;
		//case "lshift":				// no need for these as there are methods below for shifting
		//	arrayShiftLeft(arr);
		//	break;
		//case "rshift":
		//	arrayShiftRight(arr);
		//	break;
		}
	}

	private static void arrayShiftRight(long[] array) {
		long tempNum = array[array.length-1]; // keeping the last number in the array
		for (int i = array.length-1; i >= 1 ; i--) {
			array[i] = array[i - 1];
		}
		array[0] = tempNum; // the last number goes to first places
	}

	private static void arrayShiftLeft(long[] array) {
		long tempNum = array[0]; // keeping the first number in the array
		for (int i = 0; i < array.length - 1; i++) {
			array[i] = array[i+1];
		}
		array[array.length-1]=tempNum;  // the first number goes to last place
	}

	private static void printArray(long[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}