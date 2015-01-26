import java.util.ArrayList;
import java.util.Scanner;

public class Problem3_BePositive {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
		
		int countSequences = scn.nextInt();
		scn.nextLine();	// go to next line
		
		for (int i = 0; i < countSequences; i++) {
			String[] input = scn.nextLine().trim().split("\\s+");	// skip whitespaces
			
			ArrayList<Integer> numbers = new ArrayList<>();
			
			for (int j = 0; j < input.length; j++) {
				if (!input[j].equals("") ) {
					int num = Integer.parseInt(input[j]); // input[i] to input[j]
					numbers.add(num);	
				}							
			}
			
			boolean found = false;
			
			for (int j = 0; j < numbers.size(); j++) {				
				int currentNum = numbers.get(j);
				
				if (currentNum >= 0) { // 0 is not negative
					System.out.printf("%d%s", currentNum, j == numbers.size() - 1 ? "\n" : " "); // reversed true and false outputs
					found = true;
				} else {
					if (j+1 < numbers.size()){
					currentNum += numbers.get(j + 1);					
					
					if (currentNum >= 0) {	// 0 is not negative
						System.out.printf("%d%s", currentNum, j == numbers.size() - 1 ? "\n" : " " ); // reversed true and false outputs
						found = true;
					}
					j++; // skip the num used
				}
			}
		}
			
			if (!found) {
				System.out.println("(empty)");
			} 			
		}		
	}
}
